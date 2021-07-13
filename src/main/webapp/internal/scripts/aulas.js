$(document).ready( () => {
    this.RESQUEST_URL_BASE = "https://pindorama.site/api/v1";
    this.$bodyContent = $('.bodyMaterias');

    modulosEventListeners();
    modulosComponents();
    getModulosFromID();
});

function modulosEventListeners() {

}

function modulosComponents() {

}

function getIdFromURL() {
    const url = window.location.href;
    return new URL(url).searchParams.get('aulaID');
}

function getModulosFromID() {
    const aulaID = getIdFromURL();
    const requestUrl = `/api/v1/conteudo/getConteudo/${aulaID}`;

    if (aulaID === '28') {
        this.$bodyContent.append(`<video controls="" width="80%" autoplay="" name="media"><source src="${requestUrl}" type="video/mp4"></video>`);
        this.$bodyContent.append('<a id="downloadButton" href="../../internal/arquivos/Material_Complementar.pdf" download="arquivo_complementar.pdf">Download PDF</a>');
    }
    else if (aulaID === '29') {
        this.$bodyContent.append(`<video controls="" width="80%" autoplay="" name="media"><source src="${requestUrl}" type="video/mp4"></video>`);
        this.$bodyContent.append('<a id="downloadButton" href="../../internal/arquivos/Material_Complementar_tec.pdf" download="arquivo_complementarTec.pdf">Download PDF</a>');
    }
}