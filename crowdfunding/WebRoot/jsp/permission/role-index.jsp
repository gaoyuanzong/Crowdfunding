<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/meta.inc" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/jsp/inc/head.inc" %>
    <script type="text/javascript">
    	var grid=null;
        var toolbar={ items: [
				{line:true},
                { text: "增加", click: f_add , icon:"add"},
                {line:true}
            ]};
        
    	$(function ()
        {	
            var g={
            		gridid:"maingrid",
            		conditon:"condition",
                    url:"${basePath}permission/role!data.action",
                    params:[gg("likename")],
                    toolbar:toolbar,
                    checkbox:false,
            		columns: [{ display: "操作", name: "id",
                     	render: function(item){
                     		var html="<a href='javascript:f_view(\""+item.id+"\")' class='linkbutton'>查看</a>";
                            html = html+"<a href='javascript:f_edit(\""+item.id+"\")' class='linkbutton'>修改</a>";
                            html=html+"<a href='javascript:f_delete(\""+item.id+"\")' class='linkbutton'>删除</a>";
                            return html;
                        }
                     },
                     { display: "用户组名称", name: "name"},
                     { display: "学科权限", name: "subjectName",render:function(item){
                    	 if(item.subjectName&&item.subjectName!=""){
                    		 return item.subjectName;
                    	 }
                    	 return "不限";
                     }},
                     { display: "年部权限", name: "gradeGroupName",render:function(item){
                    	 if(item.gradeGroupName&&item.gradeGroupName!=""){
                    		 return item.gradeGroupName;
                    	 }
                    	 return "不限";
                     }},
                     { display: "城市权限", name: "cityName",render:function(item){
                    	 if(item.cityName&&item.cityName!=""){
                    		 return item.cityName;
                    	 }
                    	 return "不限";
                     }},
                     
                     
                     { display: "创建人", name: "createrId",render:function(item){
                    	 if(item.creater){
                    		 return item.creater.name;
                    	 }
                    	 return "";
                     }},
                     { display: "修改人", name: "modifyerId",render:function(item){
                    	 if(item.modifyer){
                    		 return item.modifyer.name;
                    	 }
                    	 return "";
                     }},
                     { display: "创建日期", name: "createTime"},
                     { display: "序号", name: "sort"}
                    ]
            };
            grid=showGrid(g);
        });
        function f_search(){
        	grid.loadData();
        }
     function f_add(){
			var win = {
					title : "增加用户组",
					name : "role-index-add-window",
					url : "${basePath}permission/role!toAdd.action",
					width:900,
					height:600,
					buttons : [ {
						text : "确定",
						onclick : function(item, dialog) {
							gg("role-index-add-window").contentWindow.f_submit(dialog);
						}
					}, {
						text : "取消",
						onclick : function(item, dialog) {
							dialog.close();
						}
					} ]
				};
		showWindow(win);
	}
     /**编辑*/
	function f_edit(id) {
		var win = {
			title : "编辑用户组",
			name : "role-index-edit-window",
			url : "${basePath}permission/role!toEdit.action?role.id=" + id,
			width:900,
			height:600,
			buttons : [ {
				text : "确定",onclick : function(item, dialog) {
					gg("role-index-edit-window").contentWindow.f_submit(dialog);
				}}, 
				{
				text : "取消",
				onclick : function(item, dialog) {
					dialog.close();
				}} 
			]
		};
		showWindow(win);
	}
	/**查看*/
	function f_view(id){
		var win = {
				title : "查看用户组",
				url : "${basePath}permission/role!detail.action?role.id=" + id,
				width:900,
				height:600,
				buttons : [
				    {text : "关闭",onclick : function(item, dialog) {
						dialog.close();
					}
				 }]
			};
		showWindow(win);
	}
	/**删除*/
	function f_delete(id){
		confirm("删除操作", "确认删除吗？", function() {
			$.getJSON("${basePath}permission/role!delete.action?role.id=" + id,function(json) {
					if (json.success) {
						grid.loadData();
					}else{
						alert(json.message,"error");
					}
			});
		});
	}
	function f_reset(){
		gg("form-search").reset();
	}
</script>
</head>
<body>
<div class="content">
<form action="" id="form-search">
   <ul>
   <li>
	   <label>用户组名称：</label>
	   <input type="text" name="condition.likename" id="likename" class="input-text"/>
   </li>
   <li><a class="l-button" onclick="f_search()">查询</a></li>
   <li><a class="l-button" onclick="f_reset()">重置</a></li>
   </ul>
   </form>
</div>
    <div id="maingrid" class="grid">
    </div>
</body>
</html>

