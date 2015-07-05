var projectSubscribe_grid = null;
var projectSubscribe_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectSubscribe_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectSubscribe_grid",
		condition : "projectSubscribeCondition",
		url : basePath+"admin/crowdfunding/projectSubscribe!data.action",
		formid : "crowdfunding_projectSubscribe_form",
		toolbar : projectSubscribe_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectSubscribe_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectSubscribe_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "用户",
					name : "userId"
				},
				{
					display : "项目ID",
					name : "projectId"
				},
				{
					display : "回报ID",
					name : "redoundId"
				},
				{
					display : "收获地址ID",
					name : "addressId"
				},
				{
					display : "认购状态",
					name : "subscribeStatus"
				},
				{
					display : "运费",
					name : "freight"
				},
				{
					display : "支持金额",
					name : "supportAmount"
				},
				{
					display : "支付金额",
					name : "payAmount"
				},
				{
					display : "支付时间",
					name : "payedTime"
				},
				{
					display : "是否需要回报",
					name : "isRedound"
				},
				{
					display : "订单号",
					name : "orderId"
				},
				{
					display : "创建时间",
					name : "createTime"
				},
				{
					display : "更新时间",
					name : "ipdateTime"
				},
				{
					display : "快递公司",
					name : "expressCompany"
				},
				{
					display : "运单号",
					name : "expressNum"
				},
				{
					display : "备注",
					name : "remarks"
				},
				{
					display : "交易单",
					name : "transactionId"
				},
				{
					display : "支付状态",
					name : "payStatus"
				},
				{
					display : "email",
					name : "email"
				},
				{
					display : "项目标签",
					name : "projectTag"
				},
				{
					display : "客服备注",
					name : "csRemarks"
				},
				{
					display : "0-无需发票；1-需要发票",
					name : "invoiceFlag"
				},
				{
					display : "发票标题",
					name : "invoiceTitle"
				},
				{
					display : "逻辑删除标志0正常1删除",
					name : "status"
				},
				{
					display : "0-未取消，1-单笔退款",
					name : "cancelTag"
				},
		]
	};
	projectSubscribe_grid = showGrid(g);
});

function projectSubscribe_search() {
	projectSubscribe_grid.loadData();
}

function projectSubscribe_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectSubscribe!delete.action?projectSubscribe.id=" + id,function(json) {
			if (json.success) {
				projectSubscribe_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectSubscribe_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectSubscribe_add_window",
		url : basePath+"admin/crowdfunding/projectSubscribe!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectSubscribe_add_window").contentWindow.projectSubscribe_add_submit(dialog);
		}
	});
}

function projectSubscribe_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectSubscribe_edit_window",
		url : basePath+"admin/crowdfunding/projectSubscribe!toEdit.action?projectSubscribe.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectSubscribe_edit_window").contentWindow.projectSubscribe_edit_submit(dialog);
		}
	});
}
