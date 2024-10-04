// Fetch data from the server and display it
function fetchData() {
    $.ajax({
        url: '/api/data',  // The endpoint to get data
        type: 'GET',       // The type of HTTP request (GET)
        success: function(data) {
            let dataHtml = '';  // Initialize an empty string to store HTML
            if (data.length > 0) {
                data.forEach(item => {
                    // For each item in the response, generate HTML
                    dataHtml += `<p><strong>Name:</strong> ${item.name}, <strong>Description:</strong> ${item.description}</p>`;
                });
            } else {
                dataHtml = '<p>No data available</p>';
            }
            $('#dataContainer').html(dataHtml);  // Insert the generated HTML into the data container
        },
        error: function(error) {
            console.error("Error fetching data", error);  // Handle error
            $('#dataContainer').html('<p>Error fetching data</p>');  // Display an error message in the UI
        }
    });
}

// Add data to the server
function addData() {
    const name = $('#name').val();
    const description = $('#description').val();

    if (name && description) {  // Check if both name and description are provided
        const data = {
            name: name,
            description: description
        };

        $.ajax({
            url: '/api/data',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),  // Convert the JavaScript object to a JSON string
            success: function(response) {
                alert("Data saved successfully!");
                fetchData();  // After saving, fetch updated data
            },
            error: function(error) {
                console.error("Error saving data", error);
                alert("Error saving data");
            }
        });
    } else {
        alert("Please enter both name and description.");
    }
}
