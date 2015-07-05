var cfDiscount_grid = null;
var cfDiscount_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfDiscount_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfDiscount_grid",
		condition : "cfDiscountCondition",
		url : basePath+"admin/crowdfunding/cfDiscount!data.action",
		formid : "crowdfunding_cfDiscount_form",
		toolbar : cfDiscount_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfDiscount_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfDiscount_edit(\""
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
					display : "discountKind",
					name : "discountKind"
				},
				{
					display : "parValue",
					name : "parValue"
				},
				{
					display : "state",
					name : "state"
				},
				{
					display : "integralTime",
					name : "integralTime"
				},
				{
					display : "overdueTime",
					name : "overdueTime"
				},
				{
					display : "useRole",
					name : "useRole"
				},
				{
					display : "remark",
					name : "remark"
				},
		]
	};
	cfDiscount_grid = showGrid(g);
});

function cfDiscount_search() {
	cfDiscount_grid.loadData();
}

function cfDiscount_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfDiscount!delete.action?cfDiscount.id=" + id,function(json) {
			if (json.success) {
				cfDiscount_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfDiscount_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfDiscount_add_window",
		url : basePath+"admin/crowdfunding/cfDiscount!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfDiscount_add_window").contentWindow.cfDiscount_add_submit(dialog);
		}
	});
}

function cfDiscount_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfDiscount_edit_window",
		url : basePath+"admin/crowdfunding/cfDiscount!toEdit.action?cfDiscount.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfDiscount_edit_window").contentWindow.cfDiscount_edit_submit(dialog);
		}
	});
}
