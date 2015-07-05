﻿<%@ page language="java" pageEncoding="UTF-8"%>
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
	        	$.getJSON("${basePath}permission/role!edit.action", param,function(json){
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
    	   var menusJson=${menusJson};//菜单列表[{menu1},{menu2}...]
      	   var initmenusJson=${initmenusJson};//用户组role下的菜单  {menuId1:{RoleMenu1},menuId2:{RoleMenu2}...}
      	   var crud=[];
		   for(var i in menusJson){
				 var data=menusJson[i];
				 if(initmenusJson[data.id]){
					 menusJson[i]["ischecked"]=true;
				 }
				 if(data.degree&&data.degree==2){
					 var createChecked=false;
					 var readChecked=false;
					 var updateChecked=false;
					 var deleteChecked=false;
					 var pid=data.id;
					 var ppid=data.pid;
					 if(initmenusJson[data.id]&&initmenusJson[data.id].roleBit){
						 var initBit=initmenusJson[data.id].roleBit||0;
						 if((initBit&2)!=0)createChecked=true;
						 if((initBit&16)!=0)readChecked=true;
						 if((initBit&8)!=0)updateChecked=true;
						 if((initBit&4)!=0)deleteChecked=true;
					 }
	            	 crud.push({id:pid+"-create" ,pid:pid, ppid:ppid, name: "新增",degree:3, bit:2,ischecked:createChecked});
	            	 crud.push({id:pid+"-read" , pid:pid, ppid:ppid, name: "查询",degree:3, bit:16,ischecked:readChecked});
	            	 crud.push({id:pid+"-update" , pid:pid, ppid:ppid, name: "修改",degree:3, bit:8,ischecked:updateChecked});
	            	 crud.push({id:pid+"-delete" , pid:pid, ppid:ppid, name: "删除",degree:3, bit:4,ischecked:deleteChecked});
				  }
		   }
		    menusJson=menusJson.concat(crud);
			//alert(JSON2.stringify(initMenusJson));
	    	treeManager=$("#tree1").ligerTree({ 
	       		  data:menusJson,
	       		  textFieldName:"name",
                  idFieldName :"id",
                  parentIDFieldName :"pid",
                  topParentIDValue:"-1",
                  nodeWidth:600
	       	});
       });
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
        
    </script>
</head>

<body>
 <form class="l-form validate">
 <input type="hidden" name="role.id" value="${role.id }">
    <div class="content">
    	<ul>
    		<li>
    			<label>用户组名称：</label>
    			<input type="text"  name="role.name" id="name" value="${role.name }" class="required input-text" />
    		</li>
    	</ul>
    	<ul>
    		<li>
    			<label>简介：</label>
    			<textarea name="role.remark" rows="8" cols="50" maxlength="800">${role.remark }</textarea>
    		</li>
    	</ul>
    	
    	<!-- 
    	<ul>
    		<li>
    			<label>菜单权限设置:</label>
    			<label>模版：<c:if test="${not empty role.roletemplate }">${role.roletemplate.name }</c:if>
    			<c:if test="${empty role.roletemplate }">自定义</c:if></label>
    		</li>
    	</ul> -->
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