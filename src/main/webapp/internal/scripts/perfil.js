$(document).ready( () => {
    this.$perfilEmail = $('#perfilEmail');
    this.$perfilPassword = $('#perfilPassword');
    this.$perfilAniversario = $('#perfilAniversario');
    this.$updatePerfil = $('#updatePerfil');
    this.$welcomeText = $('#welcome');


    loadPerfilData();
    initializePerfilListeners();
});

function initializePerfilListeners () {
    this.$updatePerfil.on('click', event => {
        updateUserData();
    });
}

function getIdFromURL() {
    const url = window.location.href;
    return new URL(url).searchParams.get('id');
}

function loadPerfilData () {

    const userId = getIdFromURL();

    $.ajax({
        url: `https://pindorama.site/api/v1/usuario/${userId}`,
        success: response => {
            this.$perfilAniversario.val(response['birthDate']);
            this.$perfilEmail.val(response['email']);
            this.$welcomeText.text(`Bem vindo, ${response['username']}`);
        },
        error: error => {
            console.log(error);
        }
    });
}
function updateUserData () {
    const userId = getIdFromURL();
    const data = {
        'email': this.$perfilEmail.val(),
        'password': this.$perfilPassword.val(),
        'birthdate': this.$perfilAniversario.val()
    }

    $.ajax({
        url: `https://pindorama.site/api/v1/usuario/update/${userId}`,
        method: 'PATCH',
        headers: {
            'content-type': 'application/json',
        },
        data: JSON.stringify(data),
        success: response => {
            alert('Usuario alterado com sucesso');
        },
        error: error => {
            console.log(error);
        }
    });
}