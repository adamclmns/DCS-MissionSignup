
class operation {
	constructor(parameters) {
		this.container = parameters.container;
		this.ato_id = parameters.ato_id;
		this.data = parameters.data;
		let that = this;

		that.init();
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
		const xhr = new XMLHttpRequest();
		xhr.open("GET","/api/ato/1",false);
		// xhr.responseType = 'json';
		console.log("Initializing...");
		xhr.send(null);
		let atoData = null;
		if(xhr.status === 200){

			atoData=JSON.parse(xhr.response);

			console.log(atoData.header.id)

		};
		const ato = new operation({
			container: $(that),
			ato_id: 'AD',
			data: atoData,

		});
	});
});