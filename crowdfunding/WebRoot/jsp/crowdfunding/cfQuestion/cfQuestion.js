var cfQuestion_grid = null;
var cfQuestion_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfQuestion_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfQuestion_grid",
		condition : "cfQuestionCondition",
		url : basePath+"admin/crowdfunding/cfQuestion!data.action",
		formid : "crowdfunding_cfQuestion_form",
		toolbar : cfQuestion_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfQuestion_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfQuestion_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "userId",
					name : "userId"
				},
				{
					display : "questionId",
					name : "questionId"
				},
				{
					display : "answer",
					name : "answer"
				},
		]
	};
	cfQuestion_grid = showGrid(g);
});

function cfQuestion_search() {
	cfQuestion_grid.loadData();
}

function cfQuestion_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfQuestion!delete.action?cfQuestion.id=" + id,function(json) {
			if (json.success) {
				cfQuestion_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfQuestion_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfQuestion_add_window",
		url : basePath+"admin/crowdfunding/cfQuestion!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfQuestion_add_window").contentWindow.cfQuestion_add_submit(dialog);
		}
	});
}

function cfQuestion_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfQuestion_edit_window",
		url : basePath+"admin/crowdfunding/cfQuestion!toEdit.action?cfQuestion.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfQuestion_edit_window").contentWindow.cfQuestion_edit_submit(dialog);
		}
	});
}
