export async function getAll() {
    const response = await fetch(`${API_ENDPOINT}/treinosAcademia`);
    return await response.json();
}