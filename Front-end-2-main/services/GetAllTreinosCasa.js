export async function getAll() {
    const response = await fetch(`${API_ENDPOINT}/treinosCasa`);
    return await response.json();
}