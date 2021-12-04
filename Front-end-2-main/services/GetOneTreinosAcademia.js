export async function getOne(id) {
    const response = await fetch(`${API_ENDPOINT}/treinosAcademia${id}`)
    return await response.json();
}