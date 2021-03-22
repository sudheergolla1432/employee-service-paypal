# employee-service-paypal

As per requirements I have created/modified 3 rest endpoints. And also handled all exceptions.
Also coded for validations of RequestBody.

Code can be found in below git repository link:



Rest Endpoints created or modified:

1. http://localhost:8080/v1/bfs/employees/1 (@GetMapping)(Modified)
	
   Default end point given by paypal is modified to get data from databse.
   
   Sample response body:
	
	{
		"id": 1,
		"first_name": "sample_first_name",
		"last_name": "sample_last_name",
		"date_of_birth": "sample_dob",
		"address": {
			"line1": "sample_line1",
			"city": "sample_city",
			"state": "sample_state",
			"country": "sample_country",
			"zip_code": "sample_pincode"
    }
}
	
   
2. http://localhost:8080/v1/bfs/create (@PostMapping)(New)
	
   New end point created to create employee in database using post request body.
   
   Example post request body:
   
		{
		"id": "1",
		"first_name": "sample_first_name",
		"last_name": "sample_last_name",
		"date_of_birth" : "sample_dob"
		}
		
	I have used OneToOne mapping between Employee and Address so saving employee will also save Address in assosiated table.
	
	Logic can be found in code.
	
	Example post response body:
	
	{
			"id": 1,
			"first_name": "sample_first_name",
			"last_name": "sample_last_name",
			"date_of_birth": "sample_dob",
			 "address": {
				"line1": "sample_line1",
				"city": "sample_city",
				"state": "sample_state",
				"country": "sample_country",
				"zip_code": "sample_pincode"
    }
   
3. http://localhost:8080/v1/bfs/employees (@GetMapping)(New)

	Get all employees and assosiated Address from db
	
	Sample response body:
	
	[
    {
        "id": 1,
        "first_name": "sample_first_name",
        "last_name": "sample_last_name",
        "date_of_birth": "sample_dob",
        "address": {
            "line1": "sample_line1",
            "city": "sample_city",
            "state": "sample_state",
            "country": "sample_country",
            "zip_code": "sample_pincode"
        }
    },
    {
        "id": 2,
        "first_name": "sample_first_name2",
        "last_name": "sample_last_name2",
        "date_of_birth": "sample_dob2",
        "address": {
            "line1": "sample_line1",
            "city": "sample_city",
            "state": "sample_state",
            "country": "sample_country",
            "zip_code": "sample_pincode"
        }
    }
]
	
		
