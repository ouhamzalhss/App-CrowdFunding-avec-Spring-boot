function getDescription(){
    var url = "getDescription";
    $.ajax({
        type : 'get',
        cache : false,
        url : url,
        success : function(response) {
            $('#ajaxLoadedContent').html(response);
        },
        error : function(response) {
            console.log("erreur de recuperation des données");
        }
    });
}

function updateDetailCommande() {
    Alert("jjjjj");

}