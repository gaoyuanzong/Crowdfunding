var projectRefund_grid = null;
var projectRefund_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectRefund_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectRefund_grid",
		condition : "projectRefundCondition",
		url : basePath+"admin/crowdfunding/projectRefund!data.action",
		formid : "crowdfunding_projectRefund_form",
		toolbar : projectRefund_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectRefund_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectRefund_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "退款人",
					name : "userId"
				},
				{
					display : "项目ID",
					name : "projectId"
				},
				{
					display : "认购单ID",
					name : "subscribeId"
				},
				{
					display : "支付订单号",
					name : "orderId"
				},
				{
					display : "退款金额",
					name : "refundAmount"
				},
				{
					display : "退款状态",
					name : "refundStatus"
				},
				{
					display : "审核状态",
					name : "checkStatus"
				},
				{
					display : "退款订单号",
					name : "refundOrderId"
				},
				{
					display : "退款时间",
					name : "refundTime"
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
					display : "交易单号",
					name : "transactionId"
				},
				{
					display : "退款类型：0整单退1部分退",
					name : "refundType"
				},
				{
					display : "退款描述",
					name : "refundDesc"
				},
				{
					display : "佣金状态：是否已经收取佣金 10 未收；20，已收（只有跳票项目的退款单这个字段才有对应值）",
					name : "commissionStatus"
				},
		]
	};
	projectRefund_grid = showGrid(g);
});

function projectRefund_search() {
	projectRefund_grid.loadData();
}

function projectRefund_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectRefund!delete.action?projectRefund.id=" + id,function(json) {
			if (json.success) {
				projectRefund_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectRefund_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectRefund_add_window",
		url : basePath+"admin/crowdfunding/projectRefund!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectRefund_add_window").contentWindow.projectRefund_add_submit(dialog);
		}
	});
}

function projectRefund_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectRefund_edit_window",
		url : basePath+"admin/crowdfunding/projectRefund!toEdit.action?projectRefund.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectRefund_edit_window").contentWindow.projectRefund_edit_submit(dialog);
		}
	});
}
