var project_grid = null;
var project_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : project_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_project_grid",
		condition : "projectCondition",
		url : basePath+"admin/crowdfunding/project!data.action",
		formid : "crowdfunding_project_form",
		toolbar : project_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='project_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='project_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "项目标签",
					name : "projectTagNames"
				},
				{
					display : "项目名称",
					name : "projectName"
				},
				{
					display : "项目类型",
					name : "projectCategotyName"
				},
				{
					display : "项目状态",
					name : "projectStatusName"
				},
				{
					display : "募集金额",
					name : "amount"
				},
				{
					display : "已募集金额",
					name : "collectedAmount"
				},
				{
					display : "募集上限",
					name : "topLimit"
				},
				{
					display : "项目发起人",
					name : "projectSponsor"
				},
				{
					display : "支持人数",
					name : "supports"
				},
				{
					display : "项目地点",
					name : "projectAddr"
				},
				{
					display : "创建时间",
					name : "createTime"
				}
		]
	};
	project_grid = showGrid(g);
});

function project_search() {
	project_grid.loadData();
}

function project_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/project!delete.action?project.id=" + id,function(json) {
			if (json.success) {
				project_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function project_add() {
	/*showDialog({
		title : "新建考试",
		name : "crowdfunding_project_add_window",
		url : basePath+"admin/crowdfunding/project!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_project_add_window").contentWindow.project_add_submit(dialog);
		}
	});*/
	var url = basePath+"admin/crowdfunding/project!toAdd.action";
	window.location.href=url;
}

function project_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_project_edit_window",
		url : basePath+"admin/crowdfunding/project!toEdit.action?project.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_project_edit_window").contentWindow.project_edit_submit(dialog);
		}
	});
}
