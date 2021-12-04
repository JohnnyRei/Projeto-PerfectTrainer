export async function getOne(id) {
    const response = await fetch(`${API_ENDPOINT}/usuarios${id}`)
    return await response.json();
}