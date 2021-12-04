export async function getAll() {
    const response = await fetch(`${API_ENDPOINT}/usuarios`);
    return await response.json();
}