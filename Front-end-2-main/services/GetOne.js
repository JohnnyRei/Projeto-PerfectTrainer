export async function getOne(id) {
    const response = await fetch(`${API_ENDPOINT}/personais${id}`)
    return await response.json();
}