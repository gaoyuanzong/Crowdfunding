var project_grid = null;
var project_toolbar = {
	items : [ {
		line : true
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectIng_grid",
		condition : "projectCondition",
		url : basePath+"admin/crowdfunding/projectStatus!ingData.action",
		formid : "crowdfunding_projectIng_form",
		toolbar : project_toolbar,
		checkbox : false,
		columns : [
				// columns start
				{
					display : "项目名称",
					name : "projectName"
				},
				{
					display : "项目类别",
					name : "projectCategotyName",
				},
				{
					display : "项目状态",
					name : "",
					render : function(item) {
						return "众筹中";
					}
				},
				//{
					//display : "审核时间",
					//name : "salesTimeDisplay",
				//},
				{
					display : "不通过原因",
					name : "auditReson",
				},
				{
					display : "融资金额（元）",
					name : "amount"
				},
				{
					display : "认投金额（元）",
					name : "investorsMount"
				},
				{
					display : "募集上限",
					name : "topLimit",
					render : function(item) {
						return item.topLimit+"%";
					}
				},
				{
					display : "开标天数",
					name : "ccollectDays"  
				},
				{
					display : "项目发起人",
					name : "cfUserName"
				},
				{
					display : "创建时间",
					name : "createDateDisplay"
				},{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='project_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>明细</a>";
						html += "<a href='javascript:;' onclick='project_pass(\""
								+ item.id
								+ "\")' class='linkbutton'>通过</a>";
						html += "<a href='javascript:;' onclick='project_refuse('0',\""
							+ item.id
							+ "\")' class='linkbutton'>拒绝</a>";
						html += "<a href='javascript:;' onclick='project_refuse('1',\""
							+ item.id
							+ "\")' class='linkbutton'>待修改</a>";
						return html;
					}
				}
		]
	};
	project_grid = showGrid(g);
});

function project_search() {
	project_grid.loadData();
}


function project_refuse(type,id){
	showDialog({
		title : "提示",
		name : "crowdfunding_project_refuse_form",
		url : basePath+"admin/crowdfunding/project!toRefuse.action?projectId="+id+"&type="+type,
		onok : function(item, dialog){
			gg("crowdfunding_project_refuse_form").contentWindow.project_refuse_submit(dialog);
		},
		height: "200",
		weight: "100"
	});
}

function project_pass(id){
	showDialog({
		title : "通过项目",
		name : "crowdfunding_project_pass_form",
		url : basePath+"admin/crowdfunding/project!toPass.action?projectId="+id,
		onok : function(item, dialog){
			gg("crowdfunding_project_pass_form").contentWindow.project_pass_submit(dialog);
		},
		height: "50",
		weight: "50"
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
