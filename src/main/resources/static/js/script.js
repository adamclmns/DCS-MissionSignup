
class operation {
	constructor(parameters) {
		this.container = parameters.container;
		this.ato_id = parameters.ato_id;
		let that = this;
		
		fetch('/api/ato/1', {
			method: 'GET',
			headers: {
				'Accept': 'application/json',
			},
		}).then(response => that.data=response.json()).then(() => that.init());
		// that.data = ato_data;
		// that.init();
		/*$.ajax({
			url: "php/operation_class.php?ato_id="+that.ato_id,
			success: function(result){
				//that.data = result;
				

			}
		});*/

	}
	
	init() {
		//ATO Header
		$('<h5>').text('HEADER').addClass('text-center').appendTo(this.container);
		const header_table = new table({
			container: this.container,
			thead_values: [
				{ text: 'ATO Day', description: 'Air Tasking Order day Identifier' },
				{ text: 'Event', description: 'Name of Event' },
				{ text: 'Time From' },
				{ text: 'Time To' },
			],
			tbody_values: [
				[
					{ text: this.data.header.id },
					{ text: this.data.header.name },
					{ text: this.data.header.time_from.ingame },
					{ text: this.data.header.time_to.ingame }
				]
			],
			classes: 'ato-table table table-striped-columns h5',
			styles: 'table-layout: fixed'
		});

		//ATO Body
		this.generate_body();
	}
	generate_body() {
		let that = this;
		$('<h5>').text('MSNDAT').addClass('text-center').appendTo(this.container);
		var $body = $('<div>').addClass('accordion').attr('id', that.ato_id + '-ato-lines-accordion').appendTo(this.container);
		$.each(that.data.lines, function(i, line_data) {
			var sortie = new line({ container: $body, line_data: line_data, index: i, ato_id: 'AD' });
		});
	}
	
}


//INNITILIZATION
$(document).ready(function(){
	$('.ato-table').each(function( ) {
		let that = this;
		console.log(this);
		const ato = new operation({
			container: $(that),
			ato_id: 'AD'
		});
	});
});