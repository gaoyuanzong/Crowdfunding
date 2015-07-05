<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/jsp/inc/head.inc" %>
    <script type="text/javascript">
    treeManager=null;
         function f_submit(dialog){
        	//alert(JSON2.stringify(treeManager.getChecked()));
        	if($("form.validate").valid()){
        		var datas=treeManager.getChecked();
        		var menus1={};//一级菜单
    			var menus2={};//二级菜单
        		if(datas){
        			for(var i in datas){
        				var dt=datas[i];
        				if(dt.data.degree==3){
        					menus1[dt.data.ppid]=dt.data.ppid;
        					if(menus2[dt.data.pid]){
        					}else{
        						menus2[dt.data.pid]=0;
        					}
        					menus2[dt.data.pid]=menus2[dt.data.pid]+dt.data.bit;
        				}
        			}
        		}
	        	var param=$("form.validate").serialize();
	        	//封装基本项
	        	var basicitem_param="";
	        	$.each(["city","gradeGroup","subject"],function(i,value){
	        		basicitem_param=basicitem_param+f_return_basicitem_param(value);
	        	});
	        	param=param+encodeURI(basicitem_param);
	        	//封装菜单选项
	        	var index=0;
	        	for(var i in menus1){
	        		param=param+"&roleMenuList["+ index +"].menuId="+i;
	        		index++;
	        	}
	        	for(var i in menus2){
	        		param=param+"&roleMenuList["+ index +"].menuId="+i+"&roleMenuList["+ index +"].roleBit="+menus2[i];
	        		index++;
	        	}
	        	//alert(param);
	        	$.getJSON("${basePath}permission/role!add.action", param,function(json){
	        		if(json.success){
	        			home_fresh();
					}else{
						alert(json.message,"error");
					}
				});
			} 
          }
         /**在客户端封装基础项参数*/
         function f_return_basicitem_param(name){
        	 var param="";
        	 var bit=0;
        	 var names=[];
        	 $("form :checkbox:checked[name='"+name+"']").each(function(){
        		 var val=$(this).val();
        		 var alt=$(this).attr("alt");
        		 if(val!=0){
					 bit=bit+(1<<val);
					 names.push(alt);
        		 }
        	 });
        	 param="&role."+name+"Bit="+bit+"&role."+name+"Name="+names.join(",");
        	 return param;
         }
   	   /**初始化tree*/
   	   $(function(){
	   		treeManager=$("#tree1").ligerTree({ 
	 		   data:[],
	 		   textFieldName:"name",
	            idFieldName :"id",
	            parentIDFieldName :"pid",
	            topParentIDValue:"-1",
	            nodeWidth:600
		 	});
   	   });
   	   /**获取tree初始值*/
       function getData(){
        	 var treedata=[];
        	 var menusJson=${menusJson};//菜单列表JSON [{menu1},{menu2}...]
        	 var crud=[];
			 for(var i in menusJson){
				 var data=menusJson[i];
				 if(data.degree&&data.degree==2){
					 var pid=data.id;
					 var ppid=data.pid;
	            	 crud.push({id:pid+"-create" ,pid:pid, ppid:ppid, name: "新增",degree:3, bit:2});
	            	 crud.push({id:pid+"-read" , pid:pid, ppid:ppid, name: "查询",degree:3, bit:16});
	            	 crud.push({id:pid+"-update" , pid:pid, ppid:ppid, name: "修改",degree:3, bit:8});
	            	 crud.push({id:pid+"-delete" , pid:pid, ppid:ppid, name: "删除",degree:3, bit:4});
				 }
			 }
			 treedata=treedata.concat(menusJson);
			 treedata=treedata.concat(crud);
        	 return treedata;
         }
         /**展开折叠*/
         function f_toggle(flag){
        	 if(treeManager){
        		 if(flag==0){
            		 treeManager.collapseAll();
            	 }else{
            		 treeManager.expandAll();
            	 }
        	 }
         }
         /**选择模版*/
         function f_change_template(obj){
        	 if(obj.value!=""){
        		 var datas=getData();
        		 if(obj.value==0){//自定义
        		 }else{//模版
        			 $.ajaxSetup({ async: false});
            		 $.getJSON("${basePath}permission/role!templateMenuList.action?role.templateId="+obj.value,null,function(jsonList){
            			 	//封装模版-菜单  -->map   
            			 	var initMap={};
            			    for(var i in jsonList){
            			    	var item=jsonList[i];
            			    	initMap[item.menuId]=item;
            			    }
            			    //封装datas -->tree
            			    for(var i in datas){
            			    	var data=datas[i];
            			    	if(data.degree&&data.degree==3){//data 是 crud 三级菜单
              						 var pid=data.pid;
              						 if(initMap[pid]){
              							 var bit=initMap[pid].roleBit;
              							 if((bit&data.bit)!=0){
              								datas[i]["ischecked"]=true;
              							 }
              						 }
              					 }else{//data 是一、二级菜单
              						 if((initMap[data.id])){
              							datas[i]["ischecked"]=true;
              						 }
              					 }
            			    }
            		 });
            		 $.ajaxSetup({ async: true});
            	 }
        		 treeManager.clear();
        		 treeManager.setData(datas);
        	 }
         }
    </script>
</head>

<body>
 <form class="l-form validate">
    <div class="content">
    	<ul>
    		<li>
    			<label>用户组名称：</label>
    			<input type="text"  name="role.name" id="name" class="required input-text" />
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>简介：</label>
    			<textarea name="role.remark" rows="8" cols="50" maxlength="800"></textarea>
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>菜单权限设置:</label>
    			<select name="role.templateId" class="required input-select" onchange="f_change_template(this)">
    				<option value="">请选择模版</option>
    				<option value="0">自定义</option>
    				<c:forEach items="${roletemplateList }" var="item">
    					<option value="${item.id }">${item.name }</option>
    				</c:forEach>
    			</select><font color="red">(请先选择套用模板)</font>
    		</li>
    	</ul>
    </div>
    </form>
    <a class="l-button" onclick="f_toggle(0)">折叠</a>
    <a class="l-button" onclick="f_toggle(1)">展开</a>
    <div id="treeDiv" style="width:80%; height:80%; margin:1px 10px 10px; padding:10px 50px 10px; float:left; border:1px solid #ccc; overflow:auto;  ">
    	<ul id="tree1"></ul>
    </div> 
    <div style="display:none">
    </div>
</body>
</html>