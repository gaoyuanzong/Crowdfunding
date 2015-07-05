var projectCategoryTag_grid = null;
var projectCategoryTag_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectCategoryTag_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectCategoryTag_grid",
		condition : "projectCategoryTagCondition",
		url : basePath+"admin/crowdfunding/projectCategoryTag!data.action",
		formid : "crowdfunding_projectCategoryTag_form",
		toolbar : projectCategoryTag_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectCategoryTag_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectCategoryTag_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "名称",
					name : "name"
				},
				{
					display : "创建时间",
					name : "createdTime"
				},
				{
					display : "修改时间",
					name : "modifiedTime"
				}
		]
	};
	projectCategoryTag_grid = showGrid(g);
});

function projectCategoryTag_search() {
	projectCategoryTag_grid.loadData();
}

function projectCategoryTag_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectCategoryTag!delete.action?projectCategoryTag.id=" + id,function(json) {
			if (json.success) {
				projectCategoryTag_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectCategoryTag_add() {
	showDialog({
		width : 350,
		height : 200,
		title : "新建分类",
		name : "crowdfunding_projectCategoryTag_add_window",
		url : basePath+"admin/crowdfunding/projectCategoryTag!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectCategoryTag_add_window").contentWindow.projectCategoryTag_add_submit(dialog);
		}
	});
}

function projectCategoryTag_edit(id) {
	showDialog({
		width : 350,
		height : 200,
		title : "修改分类",
		name : "crowdfunding_projectCategoryTag_edit_window",
		url : basePath+"admin/crowdfunding/projectCategoryTag!toEdit.action?projectCategoryTag.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectCategoryTag_edit_window").contentWindow.projectCategoryTag_edit_submit(dialog);
		}
	});
}
