var projectRedound_grid = null;
var projectRedound_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectRedound_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectRedound_grid",
		condition : "projectRedoundCondition",
		url : basePath+"admin/crowdfunding/projectRedound!data.action",
		formid : "crowdfunding_projectRedound_form",
		toolbar : projectRedound_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectRedound_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectRedound_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "项目ID",
					name : "projectId"
				},
				{
					display : "回报金额",
					name : "amount"
				},
				{
					display : "回报类型",
					name : "redoundType"
				},
				{
					display : "回报内容",
					name : "redoundContent"
				},
				{
					display : "图片",
					name : "redoundImage"
				},
				{
					display : "上限",
					name : "limits"
				},
				{
					display : "运费",
					name : "freight"
				},
				{
					display : "回报天次",
					name : "redoundDays"
				},
				{
					display : "0-不可开发票，1-可开发票",
					name : "invoiceStatus"
				},
				{
					display : "创建时间",
					name : "createTime"
				},
				{
					display : "更新时间",
					name : "updateTime"
				},
				{
					display : "排序",
					name : "ind"
				},
		]
	};
	projectRedound_grid = showGrid(g);
});

function projectRedound_search() {
	projectRedound_grid.loadData();
}

function projectRedound_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectRedound!delete.action?projectRedound.id=" + id,function(json) {
			if (json.success) {
				projectRedound_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectRedound_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectRedound_add_window",
		url : basePath+"admin/crowdfunding/projectRedound!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectRedound_add_window").contentWindow.projectRedound_add_submit(dialog);
		}
	});
}

function projectRedound_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectRedound_edit_window",
		url : basePath+"admin/crowdfunding/projectRedound!toEdit.action?projectRedound.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectRedound_edit_window").contentWindow.projectRedound_edit_submit(dialog);
		}
	});
}
