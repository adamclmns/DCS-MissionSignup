// JavaScript Document
$('#mizEditor input').data ('getProblems', function () {
		$this = $(this);
		var problems = { errors: [], warnings: [] };
		if ($this.hasClass()) {

		} else {
		($this.val() == "") ? problems.errors.push($(this).data('error')): null;
		}

		
		return problems;
    }
);