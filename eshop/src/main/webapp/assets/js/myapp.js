// Handle Active menu in Navbar

$(function() {
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Home':
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	var $table = $('#productListTable');
		
	// Execute the below 
	if($table.length){
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		$table.DataTable({
			ajax: {
				url: jsonUrl,
				dataSrc: '',
			},
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/'+ data +'.png" class="dataTableImg"/>';
					}
				},
				{data: 'name'},
				{data: 'brand'},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return '&#8377;'+ data;
					}
				},
				{data: 'quantity'},
				{
					data: 'id',
					mRender: function(data, type, row){
						var str = '';
						str += '<a href = "'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary"> <span class="glyphicon glyphicon-eye-open"></span> </a> &#160';
						str += '<a href = "'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary"> <span class="glyphicon glyphicon-shopping-cart"></span> </a>'
						return str;
					},
					bSortable: false
				}
			]
		})
	}
})

