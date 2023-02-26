// JavaScript Document
class table {
	constructor(parameters) {;		
		this.tableElement = $('<table></table>').addClass(parameters.classes).attr('style', parameters.styles).appendTo(parameters.container);
		let headline = parameters.headline ? this.generate_th(parameters.headline) : null;
		headline ? headline.addClass('text-center') : null;
		parameters.thead_values ? this.generate_th(parameters.thead_values) : false;
		parameters.tbody_values ? this.generate_rows(parameters.tbody_values) : null;
	}
	
	//Generate Table Headers
	generate_th(list) {
		let that = this;
		let thead = $('<thead>');
		let tr = $('<tr>');
		let header_cells = this.create_elements({
			list: list,
			element: '<th>',
			parent: tr
		});
		
		thead.append(tr).appendTo(this.tableElement);
		return thead;
	}
	
	//Generate TABLE ROWS
	generate_rows(rows) {
		
		let that = this;
		let tbody = $('<tbody>');
		this.tableElement.children().length > 0 ? tbody.addClass('table-group-divider') : null;

		let table_rows = this.create_elements({
			list: rows,
			element: '<tr>',
			parent: tbody,
			remarks: function (row, item) { 
				that.create_elements({ list: item, parent: row, element: '<td>'}); 
			}
		});

		tbody.append(table_rows).appendTo(this.tableElement);
		return tbody;
	}
	
	create_elements(parameters) {
		//parmeters : list (list of data to cycle through), element (type of element to create), parent (container to append elements to), remarks - is a function variables are: (container, item)
		function create_element(parameters, item) {
			let $elem = $( parameters.element);
			$(parameters.parent).append($elem);
			item.text ? $elem.html(item.text) : null;
			item.description ? $elem.prop('title', item.description) : null;
			item.span ? $elem.prop('colspan', item.span) : null;
			parameters.remarks ? parameters.remarks($elem, item) : null;
			$elem.appendTo(parameters.parent);
		}

		Array.isArray(parameters.list) ? $.each(parameters.list, function(i, item) { create_element(parameters, item); }) : create_element(parameters, parameters.list);
	}
}