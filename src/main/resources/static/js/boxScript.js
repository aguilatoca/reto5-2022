$(document).ready(function (){
    getCategoryBoxes();
    getBoxes();
});

function getFrontBoxData(){
    let k={
        id:$("#idBox").val(),
        name:$("#nameBox").val(),
        capacity:$("#capacityBox").val(),
        location:$("#locationBox").val(),
        description:$("#descriptionBox").val(),
        category:{
            id:$("#categorySelect").val()
        }
    }
    return k;
}
function cleanFields(){
    $("#idBox").val("");
    $("#nameBox").val("");
    $("#capacityBox").val("");
    $("#locationBox").val("");
    $("#descriptionBox").val("");
    $("#categorySelect").val("").change();
}


function getCategoryBoxes(){
    $.ajax({
        url : "api/Category/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#categorySelect").empty();
            for(let i=0;i<p.length;i++){
                let s=`
                    <option value="${p[i].id}">${p[i].name}</option>                
                `;
                $("#categorySelect").append(s);

            }

        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function saveBox(){
    let data=getFrontBoxData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Box/save",
        type : 'POST',
        dataType : 'json',
        contentType:'application/json',
        data:dataToSend,
        success : function(p) {
            console.log(p);
            cleanFields();
            getBoxes();

        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function getBoxes(){
    $.ajax({
        url : "api/Box/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#results").empty();
            let l="";
            for (let i=0;i<p.length;i++){
                l+=`<div class="col">
                        <div class="card"><div class="card-header">
                                    <h5 class="card-title">${p[i].name}</h5>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">${p[i].description}</p>
                                    <p class="card-text">Capacidad: ${p[i].capacity}</p>
                                    <p class="card-text">Objetivo: ${p[i].location}</p>
                                    <p class="card-text">Categoria: ${p[i].category.name}</p>
                                </div>
                                <div class="card-footer">
                                      <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getLibById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteLibById(${p[i].id})'>Borrar!</button>
                                    </div>
                                
                                </div>
                        </div>
                    </div>
                    `;
            }
            $("#results").append(l);
        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}
function getBoxById(idBox){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Box/"+idBox,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idBox").val(p.id);
            $("#nameBox").val(p.name);
            $("#capacityBox").val(p.capacity);
            $("#locationBox").val(p.location);
            $("#descriptionBox").val(p.description);
            $("#categorySelect").val(p.category.id).change();

        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}
function updateBox(){
    let data=getFrontBoxData();

    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Box/update",
        type : 'PUT',
        dataType : 'json',
        contentType:'application/json',
        data:dataToSend,
        success : function(p) {
            console.log(p);
            cleanFields();
            getLibs();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateBox(){
    cleanFields();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function deleteBoxById(idBox){
    $.ajax({
        url : "api/Box/"+idBox,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            getLibs();
        },
        error : function(xhr, status) {
            alert('OjO con eso ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });

}