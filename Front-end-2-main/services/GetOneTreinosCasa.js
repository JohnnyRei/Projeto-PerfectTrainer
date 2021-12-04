export async function getOne(id) {
    const response = await fetch(`${API_ENDPOINT}/treinosCasa${id}`)
    return await response.json();
}