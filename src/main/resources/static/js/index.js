$(document).ready(()=>{
    $('#input').on("change",(evt) =>{
        let text = $('#input').val();
        $.get('/findbyupa/'+text).done((data)=>{
                var data = data.split(',')
                console.log(data);
                if(data.lenght==0)
                {
                    $('#errmsg').text('No data found.');
                }
                else
                {
                    $('#input').val('');
                    let dataToAdd = "<tr><td>"+ data[0]+"</td><td>"+ data[1]+"</td><td>"+ data[2]+"</td><td>"+ data[3]+"</td><td>"+ data[4]+"</td><td>"+ data[5]+"</td></tr>";
                    $('#tableData').append(dataToAdd)
                }

            }).fail((xhr)=>{
            alert('Prob contacting server');
            console.log(xhr);
        });
    });


    $('#tab2csv').on("click",(evt) =>{
        var $table = $('#tableData');
        var csv = $table.table2CSV({delivery:'value'});
        $.get('/postData',{text:csv});
        downloadFile('todaySearchData.csv', 'data:text/csv;charset=UTF-8,' + encodeURIComponent(csv));
    });

    $.get('/getcount').done((data)=>{$('#rowCount').text(data);});
    $.get('/getlastmodifieddate').done((data)=>{$('#lastImport').text(data);});
});



function downloadFile(fileName, urlData) {
    console.log(urlData);
    var aLink = document.createElement('a');
    aLink.download = fileName;
    aLink.href = urlData;
    document.body.appendChild(aLink);
    aLink.click();
    document.body.removeChild(aLink);
    delete aLink;
}

var regex = new RegExp("(.*?)\.(csv)$");

function triggerValidation(el) {
    if (!(regex.test(el.value.toLowerCase()))) {
        el.value = '';
        alert('Please select correct file format');
    }
}

function SubmitForm()
{
    document.getElementById("form1").submit();
}