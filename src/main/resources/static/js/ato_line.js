// JavaScript Document
class line {
	constructor(parameters) {
		this.ato_id = parameters.ato_id;
		this.data = parameters.line_data;
		let $line = $('<div>').addClass('accordion-item').appendTo(parameters.container);
		let $header = $('<h2>').addClass('accordion-header').attr('id', parameters.ato_id + '-line-header-' + parameters.index).appendTo($line);
		this.collapse = $('<div>').addClass('accordion-collapse collapse').attr('id', parameters.ato_id + '-line-' + parameters.index).appendTo($line);
		this.collapse.attr('aria-labelledby', '#' + parameters.ato_id + '-line-header-' + parameters.index).attr('data-bs-parent', '#' + parameters.container.attr('id'));
		this.body = $('<div>').addClass('accordion-body').appendTo(this.collapse);
		this.button = $('<button>').attr('data-bs-toggle', 'collapse').attr('data-bs-target', '#' + parameters.ato_id + '-line-' + parameters.index).addClass('accordion-button collapsed').appendTo($header);

		this.generate_sortie_header(parameters);
		this.generate_sortie_details();
	}
	generate_sortie_header(parameters) {
		let isFirstRow = parameters.container.children().length;

		let thead_values;
		if (parameters.index < 1) {
				thead_values = [
				{ text: 'Tasked Unit' },
				{ text: 'Mission Number' },
				{ text: 'Callsign' },
				{ text: 'Aircraft Type' },
				{ text: 'Primary Mission' },
				{ text: 'Secondary Mission' },
				{ text: 'Departure Location' },
				{ text: 'Recovery Location' },
				{ text: 'Mode 3' },
			];
		} else {

			thead_values = null;
		}

		let msndat = this.data.msndat;
		const sortie_msndat = new table({
			container: this.button,
			thead_values: thead_values,
			tbody_values: [
				[
					{ text: msndat.tasked_unit },
					{ text: this.ato_id + this.format_number(3, msndat.mission_num)  },
					{ text: this.format_callsigns(msndat.ac_cs) },
					{ text: msndat.num_ac + 'x ' + msndat.ac_type },
					{ text: msndat.prim_msn },
					{ text: msndat.sec_msn },
					{ text: msndat.dep_location.icao },
					{ text: msndat.rec_location.icao },
					{ text: this.format_mode_3(msndat.mode_3) }
				]
			],
			classes: 'ato-table table table-borderless table-striped-columns mx-2 my-0',
			styles: 'table-layout: fixed'
		});
	}
	format_number(width, x) {
		return (new Array(width).join('0') + x).substr(-width);
	}
	format_signup(data, index) {
		let signups = data.users;
		console.log(index);
		let html = signups[index] === null ? $('<button>').addClass("btn btn-primary btn-sm fs-6 text").text('OPEN').attr('type', 'button') : signups[index];
		return html;
	}
	generate_sortie_details() {
		let that = this;
		
		//SIGNUPS
		if (this.data.signups) {
			const sortie_amsnloc = new table({
				container: this.body,
				headline: { text: "SIGNUPS", span: 4 },
				thead_values: [
					{ text: "Lead" },
					{ text: "Dash 2" },
					{ text: "Dash 3" },
					{ text: "Dash 4" }
				],
				tbody_values: 
					this.format_row_values(this.data.signups, [
							that.format_signup,
							that.format_signup,
							that.format_signup,
							that.format_signup
						]
			   	),
				classes: 'table table-striped-columns table-secondary',
				styles: 'table-layout: fixed'
			});
		}
		//GTGTLOC
		if (this.data.gtgtloc) {
			const sortie_gtgtloc = new table({
				container: this.body,
				headline: { text: "GTGTLOC", description: "Ground Target Location", span: 8 },
				thead_values: [
					{ text: "NET", description: "No Earlier Than" },
					{ text: "NLT", description: "No Later Than" },
					{ text: "TOT", description: "Time On Target" },
					{ text: "Priority" },
					{ text: "Target ID" },
					{ text: "Target Description" },
					{ text: "DMPI Location", description: "Desired Mean Point of Impact Location" },
					{ text: "DMPI Elevation", description: "Desired Mean Point of Impact Elevation" },
				],
				tbody_values: 
					this.format_row_values(this.data.gtgtloc, [
						"net",
						"nlt",
						"tot",
						function (gtgt_data) { let priority = gtgt_data.priority == "P" ? "PRIMARY" : "ALTERNATE"; return priority; },
						function (gtgt_data) { return that.format_number(4, gtgt_data.target_id); },
						"description",
						function (gtgt_data) { let coords = new coordinates(gtgt_data.dmpi.lat, gtgt_data.dmpi.long); return coords.location; },
						function (gtgt_data) { return gtgt_data.dmpi.elev; },
					])
				,
				classes: 'table table-striped-columns table-dark',
				styles: 'table-layout: fixed'
			});
		}
		//AMSNLOC
		if (this.data.amsnloc) {
			const sortie_amsnloc = new table({
				container: this.body,
				headline: { text: "AMSNLOC", description: "Air Mission Location", span: 4 },
				thead_values: [
					{ text: "Start Time" },
					{ text: "End Time" },
					{ text: "Location" },
					{ text: "Mission Altitude" }
				],
				tbody_values: 
					[ 
						[
							{ text: this.data.amsnloc.start_time },
							{ text: this.data.amsnloc.end_time },
							{ text: this.data.amsnloc.location_name },
							{ text: this.data.amsnloc.msn_altitude }
						] 
					]
				,
				classes: 'table table-striped-columns table-dark',
				styles: 'table-layout: fixed'
			});
		}
		//ARINFO
		if (this.data.arinfo) {
			const sortie_arinfo = new table({
				container: this.body,
				headline: { text: "ARINFO", description: "Air Refeuling Information", span: 8 },
				thead_values: [
					{ text: "Aircraft Type" },
					{ text: "Callsign" },
					{ text: "Contact Point" },
					{ text: "Tanker Altitude" },
					{ text: "Frequency" },
					{ text: "Offload", description: "Amount of fuel to offload in thousands of pounds" },
					{ text: "Refueling System" },
					{ text: "TACAN" }
				],
				tbody_values: 
					[ 
						[
							{ text: this.data.arinfo.ac_type },
							{ text: this.format_callsigns(this.data.arinfo.tnkr_cs) },
							{ text: this.data.arinfo.tnkr_cp },
							{ text: this.data.arinfo.tnkr_alt },
							{ text: this.data.arinfo.frequency.name, description: this.data.arinfo.frequency.freq },
							{ text: this.data.arinfo.offload },
							{ text: this.data.arinfo.refuel_system },
							{ text: this.data.arinfo.tacan },
						] 
					]
				,
				classes: 'table table-striped-columns table-dark',
				styles: 'table-layout: fixed'
			});
		}
		//PKGCMD
		if (this.data.pkgcmd) {
			const sortie_pkgcmd = new table({
				container: this.body,
				headline: { text: "PKGCMD", description: "Package Commander", span: 4 },
				thead_values: [
					{ text: "Package ID" },
					{ text: "PC Callsign", description: "Package Commander Callsign" },
					{ text: "PC Mission Number", description: "Package Commander Mission Number" },
					{ text: "PC Unit ID", description: "Package Commander Unit ID"}
				],
				tbody_values: 
					[ 
						[
							{ text: this.data.pkgcmd.pkg_id },
							{ text: this.format_callsigns(this.data.pkgcmd.pkg_cmdr_cs) },
							{ text: this.ato_id + this.format_number(3, this.data.pkgcmd.pkg_cmdr_mission_num) },
							{ text: this.data.pkgcmd.pkg_cmdr_unit_id },
						] 
					]
				,
				classes: 'table table-striped-columns table-dark',
				styles: 'table-layout: fixed'
			});
		}
		
		//PKGDAT
		if (this.data.pkgdat) {
			const sortie_pkgdat = new table({
				container: this.body,
				headline: { text: "PKGDAT (ID: " + this.data.pkgdat[0].pkg_id + ")", description: "Package Data", span: 5 },
				thead_values: [
					{ text: "Tasked Unit" },
					{ text: "Mission Number" },
					{ text: "Primary Mission" },
					{ text: "Aircraft Type" },
					{ text: "Callsign" }
				],
				tbody_values: 
					this.format_row_values(this.data.pkgdat, [
						"tasked_unit",
						function (pkg_data) { return that.ato_id + that.format_number(3, pkg_data.mission_num); },
						"prim_msn",
						function (pkg_data) { return pkg_data.num_ac + 'x ' + pkg_data.ac_type; },
						function (pkg_data) { return that.format_callsigns(pkg_data.ac_cs); },
					])
				,
				classes: 'table table-striped-columns table-dark',
				styles: 'table-layout: fixed'
			});
		}
	}
	format_callsigns(ac_cs) {
		var callsigns = ac_cs.prefix + ' ' + ac_cs.suffix[0];
		callsigns += this.seperate_numbers(ac_cs.suffix);
		return callsigns;
	}
	format_mode_3 (mode_list) {
		var modes = mode_list[0];
		modes += this.seperate_numbers(mode_list);
		return modes;
	}
	
	seperate_numbers(arr) {

		let str = "";
		for (let i = 1; i < arr.length; i++) {
			str += '/' + arr[i];
		}
		return str;
	}
	
	format_row_values(rows, formatter) {
		let new_rows = []
		
		$.each(rows, function(i, row) { 
			let cells = [];
			$.each(formatter, function(o, cell) {
				let prop = formatter[o];

				let data = (typeof formatter[o] == "string") ?  rows[i][cell] : formatter[o](rows[i], o);
				data = data ? data : "-";
				cells.push({text: data});
			});		
			new_rows.push(cells);
		});

		return new_rows;
	}
}
