const BASE_URL = window.location.hostname === 'localhost'
    ? 'http://localhost:8080/moveflix'
    : '/moveflix';

async function cadastrarFilme(data) {
    try {
        const res = await fetch(`${BASE_URL}/filmes`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        return res.ok;
    } catch (err) {
        console.error(err);
        return false;
    }
}

async function listarFilmes() {
    try {
        const res = await fetch(`${BASE_URL}/filmes_insights/listar-filmes-5-ultimos-anos`);
        return await res.json();
    } catch (err) {
        console.error(err);
        return [];
    }
}
