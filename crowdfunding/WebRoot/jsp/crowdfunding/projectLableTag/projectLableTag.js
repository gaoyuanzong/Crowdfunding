var projectLableTag_grid = null;
var projectLableTag_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectLableTag_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectLableTag_grid",
		condition : "projectCategoryTagCondition",
		url : basePath+"admin/crowdfunding/projectCategoryTag!data.action",
		formid : "crowdfunding_projectLableTag_form",
		toolbar : projectLableTag_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectLableTag_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectLableTag_edit(\""
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
	projectLableTag_grid = showGrid(g);
});

function projectLableTag_search() {
	projectLableTag_grid.loadData();
}

function projectLableTag_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectCategoryTag!delete.action?projectCategoryTag.id=" + id,function(json) {
			if (json.success) {
				projectLableTag_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectLableTag_add() {
	showDialog({
		height : "150",
		width : "400",
		title : "新建标签",
		name : "crowdfunding_projectLableTag_add_window",
		url : basePath+"admin/crowdfunding/projectCategoryTag!toAddLable.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectLableTag_add_window").contentWindow.projectLableTag_add_submit(dialog);
		}
	});
}

function projectLableTag_edit(id) {
	showDialog({
		height : "150",
		width : "400",
		title : "修改标签",
		name : "crowdfunding_projectLableTag_edit_window",
		url : basePath+"admin/crowdfunding/projectCategoryTag!toEditLable.action?projectCategoryTag.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectLableTag_edit_window").contentWindow.projectLableTag_edit_submit(dialog);
		}
	});
}
