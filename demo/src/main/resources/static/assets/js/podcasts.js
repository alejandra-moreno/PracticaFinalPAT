const APIController = (function() {
    
    const clientId = '80acfc9b7bf644efa5ffb18e72288913';
    const clientSecret = '6c5bab352eb148c79dd5cc1e5ff2f045';

    // private methods
    const _getToken = async () => {

        const result = await fetch('https://accounts.spotify.com/api/token', {
            method: 'POST',
            headers: {
                'Content-Type' : 'application/x-www-form-urlencoded', 
                'Authorization' : 'Basic ' + btoa(clientId + ':' + clientSecret)
            },
            body: 'grant_type=client_credentials'
        });

        const data = await result.json();
        return data.access_token;
    }
    
    const _getGenres = async (token) => {

        const result = await fetch(`https://api.spotify.com/v1/browse/categories?locale=es`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        return data.categories.items;
    }

    const _getPlaylistByGenre = async (token, genreId) => {

        const limit = 10;
        
        const result = await fetch(`https://api.spotify.com/v1/browse/categories/${genreId}/playlists?limit=${limit}`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        return data.playlists.items;
    }

    const _getTracks = async (token, tracksEndPoint) => {

        const limit = 10;

        const result = await fetch(`${tracksEndPoint}?limit=${limit}`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        return data.items;
    }

    const _getTrack = async (token, trackEndPoint) => {

        const result = await fetch(`${trackEndPoint}`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        return data;
    }

    //FUNCION OBTENER A LOS ARTISTAS
    /*const artistaId = document.querySelector('#artistasId');
    const  _getArtistsSearch = async (token) => {

        console.log("Prueba buscar artista: "+artistaId.value);
        const result = await fetch(`https://api.spotify.com/v1/search?q=${artistaId.value}&type=artist`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        let html="";
        console.log(data);
        for(var i=0;i<data.artists.items.length;i++){
            console.log(data.artists.items[i].name)
            const detailDiv = document.querySelector('#artist-detail');
            // any time user clicks a new song, we need to clear out the song detail div
            if(i==0){
                detailDiv.innerHTML = '';
            }
            if(data.artists.items[i].images.length != 0){                
                html = 
                `
                <div class="row col-sm-12 px-0">
                    <img src="${data.artists.items[i].images[0].url}" alt="" style="height: 30rem;">        
                </div>
                <div class="row col-sm-12 px-0">
                    <label for="artist" class="form-label col-sm-12">${data.artists.items[i].name}</label>
                </div> 
                `;
            }else{
                html="";
            }

            detailDiv.insertAdjacentHTML('beforeend', html)
        }
        
        return data.artists.items;
    }
    //FUNCION OBTENER LAS CANCIONES
    const cancionId = document.querySelector('#cancionId');
    const _getCancionesSearch = async (token) => {

        console.log("Prueba canci??n");
        const result = await fetch(`https://api.spotify.com/v1/search?q=${cancionId.value}&type=track`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        console.log(data);
        for(var i=0;i<data.tracks.items.length;i++){
            console.log(data.tracks.items[i].name)
            const detailDiv = document.querySelector('#track-detail');
            // any time user clicks a new song, we need to clear out the song detail div
            if(i==0){
                detailDiv.innerHTML = '';
            }
            const html = 
            `
            <div class="row col-sm-12 px-0 mx-4 pt-3">
                    <img src="${data.tracks.items[i].album.images[0].url}" alt="" style="height: 20rem;">        
                </div>
            <div class="row col-sm-12 px-0 mx-5 pb-5">
                <label for="artist" class="form-label col-sm-12">${data.tracks.items[i].name} de ${data.tracks.items[i].artists[0].name}</label>
            </div>
            `;

            detailDiv.insertAdjacentHTML('beforeend', html)
        }
        return data.tracks.items;

    }*/
    //FUNCION OBTENER LOS PODCASTS
    const showId = document.querySelector('#podcastId');
    const _getEpisodioSearch = async (token) => {

        console.log("Prueba episodio: "+showId.value);
        const result = await fetch(`https://api.spotify.com/v1/search?q=${showId.value}&type=show&market=ES`, {
            method: 'GET',
            headers: { 'Authorization' : 'Bearer ' + token}
        });

        const data = await result.json();
        console.log(data);
        for(var i=0;i<data.shows.items.length;i++){
            console.log(data.shows.items[i].name)
            const detailDiv = document.querySelector('#podcast-detail');
            // any time user clicks a new song, we need to clear out the song detail div
            if(i==0){
                detailDiv.innerHTML = '';
            }
            const html = 
            `
            <div class="row align-items-center">
                <div class="col-5 px-5 mx-2 pt-4">
                    <img src="${data.shows.items[i].images[0].url}" alt="" style="height: 25rem;width: 25rem;"> 
                </div>
                <div class="col-6 pe-5">
                    <h6>DESCRIPCI??N:</h3>
                    <p class="btn btn-success col-sm-12" style="text-align: justify;"">${data.shows.items[i].description}</button>
                </div>      
            </div>
            <div class="row px-0 mx-5 pb-5 pt-2">
                <label for="artist" class="form-label col-sm-12">${data.shows.items[i].name}</label>
            </div>
            `;

            detailDiv.insertAdjacentHTML('beforeend', html)
        }
        return data.shows.items;
    }

    return {
        getToken() {
            return _getToken();
        },
        getGenres(token) {
            return _getGenres(token);
        },
        getPlaylistByGenre(token, genreId) {
            return _getPlaylistByGenre(token, genreId);
        },
        getTracks(token, tracksEndPoint) {
            return _getTracks(token, tracksEndPoint);
        },
        getTrack(token, trackEndPoint) {
            return _getTrack(token, trackEndPoint);
        },
        /*getArtistsSearch(token){
            return _getArtistsSearch(token);
        }
        getCancionesSearch(token){
            return _getCancionesSearch(token);
        }
        getAlbumSearch(token){
            return _getAlbumSearch(token);
        },*/
        getEpisodioSearch(token){
            return _getEpisodioSearch(token);
        }
    }
})();


// UI Module
const UIController = (function() {

    //object to hold references to html selectors
    const DOMElements = {
        selectGenre: '#select_genre',
        selectPlaylist: '#select_playlist',
        buttonSubmit: '#btn_submit',
        buttonPodcast: '#btn_podcast',
        divSongDetail: '#podcast-detail',
        hfToken: '#hidden_token',
        divSonglist: '.song-list'
    }

    //public methods
    return {

        //method to get input fields
        inputField() {
            return {
                genre: document.querySelector(DOMElements.selectGenre),
                playlist: document.querySelector(DOMElements.selectPlaylist),
                tracks: document.querySelector(DOMElements.divSonglist),
                submit: document.querySelector(DOMElements.buttonSubmit),
                submitPodcast: document.querySelector(DOMElements.buttonPodcast),
                songDetail: document.querySelector(DOMElements.divSongDetail)
            }
        },

        // need methods to create select list option
        createGenre(text, value) {
            const html = `<option value="${value}">${text}</option>`;
            document.querySelector(DOMElements.selectGenre).insertAdjacentHTML('beforeend', html);
        }, 

        createPlaylist(text, value) {
            const html = `<option value="${value}">${text}</option>`;
            document.querySelector(DOMElements.selectPlaylist).insertAdjacentHTML('beforeend', html);
        },

        // need method to create a track list group item 
        createTrack(id, name) {
            const html = `<a href="#" class="list-group-item list-group-item-action list-group-item-light" id="${id}">${name}</a>`;
            document.querySelector(DOMElements.divSonglist).insertAdjacentHTML('beforeend', html);
        },

        // need method to create the song detail
        createTrackDetail(img, title, artist) {

            const detailDiv = document.querySelector(DOMElements.divSongDetail);
            // any time user clicks a new song, we need to clear out the song detail div
            detailDiv.innerHTML = '';

            const html = 
            `
            <div class="row col-sm-12 px-0">
                <img src="${img}" alt="" style="height: 30rem;">        
            </div>
            <div class="row col-sm-12 px-0">
                <label for="Genre" class="form-label col-sm-12">${title}:</label>
            </div>
            <div class="row col-sm-12 px-0">
                <label for="artist" class="form-label col-sm-12">By ${artist}:</label>
            </div> 
            `;

            detailDiv.insertAdjacentHTML('beforeend', html)
        },

        // need method to create the artist detail
        /*createArtistDetail(img, artist) {

            const detailDiv = document.querySelector(DOMElements.divSongDetail);
            // any time user clicks a new song, we need to clear out the song detail div
            detailDiv.innerHTML = '';

            const html = 
            `
            <div class="row col-sm-12 px-0">
                <img src="${img}" alt="" style="height: 30rem;">        
            </div>
            <div class="row col-sm-12 px-0">
                <label for="artist" class="form-label col-sm-12">By ${artist}:</label>
            </div> 
            `;

            detailDiv.insertAdjacentHTML('beforeend', html)
        },*/

        resetTrackDetail() {
            this.inputField().songDetail.innerHTML = '';
        },

        resetTracks() {
            this.inputField().tracks.innerHTML = '';
            this.resetTrackDetail();
        },

        resetPlaylist() {
            this.inputField().playlist.innerHTML = '';
            this.resetTracks();
        },
        
        storeToken(value) {
            document.querySelector(DOMElements.hfToken).value = value;
        },

        getStoredToken() {
            return {
                token: document.querySelector(DOMElements.hfToken).value
            }
        }
    }

})();

const APPController = (function(UICtrl, APICtrl) {

    // get input field object ref
    const DOMInputs = UICtrl.inputField();

    // get genres on page load
    const loadGenres = async () => {
        //get the token
        const token = await APICtrl.getToken();           
        //store the token onto the page
        UICtrl.storeToken(token);
        //get the genres
        const genres = await APICtrl.getGenres(token);
        //populate our genres select element
        genres.forEach(element => UICtrl.createGenre(element.name, element.id));
    }

    // create genre change event listener
    DOMInputs.genre.addEventListener('change', async () => {
        //reset the playlist
        UICtrl.resetPlaylist();
        //get the token that's stored on the page
        const token = UICtrl.getStoredToken().token;        
        // get the genre select field
        const genreSelect = UICtrl.inputField().genre;       
        // get the genre id associated with the selected genre
        const genreId = genreSelect.options[genreSelect.selectedIndex].value;             
        // ge the playlist based on a genre
        const playlist = await APICtrl.getPlaylistByGenre(token, genreId);       
        // create a playlist list item for every playlist returned
        playlist.forEach(p => UICtrl.createPlaylist(p.name, p.tracks.href));
    });
     

    // create submit button click event listener
    DOMInputs.submit.addEventListener('click', async (e) => {
        // prevent page reset
        e.preventDefault();
        // clear tracks
        UICtrl.resetTracks();
        //get the token
        const token = UICtrl.getStoredToken().token;        
        // get the playlist field
        const playlistSelect = UICtrl.inputField().playlist;
        // get track endpoint based on the selected playlist
        const tracksEndPoint = playlistSelect.options[playlistSelect.selectedIndex].value;
        // get the list of tracks
        const tracks = await APICtrl.getTracks(token, tracksEndPoint);
        // create a track list item
        tracks.forEach(el => UICtrl.createTrack(el.track.href, el.track.name))        
    });

    DOMInputs.submitPodcast.addEventListener('click', async (e) => {
        // prevent page reset
        e.preventDefault();
        // clear tracks
        UICtrl.resetTracks();
        //get the token
        const token = UICtrl.getStoredToken().token; 
        // get artists
        const podcasts = await APICtrl.getEpisodioSearch(token);
    });

    // create song selection click event listener
    DOMInputs.tracks.addEventListener('click', async (e) => {
        // prevent page reset
        e.preventDefault();
        UICtrl.resetTrackDetail();
        // get the token
        const token = UICtrl.getStoredToken().token;
        // get the track endpoint
        const trackEndpoint = e.target.id;
        //get the track object
        const track = await APICtrl.getTrack(token, trackEndpoint);
        // load the track details
        UICtrl.createTrackDetail(track.album.images[2].url, track.name, track.artists[0].name);
    }); 

    return {
        init() {
            console.log('App is starting');
            loadGenres();
        }
    }

})(UIController, APIController);

// will need to call a method to load the genres on page load
APPController.init();



