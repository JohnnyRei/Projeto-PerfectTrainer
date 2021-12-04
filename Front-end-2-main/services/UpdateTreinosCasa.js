const updateTreinosCasa = treinosCasa => {
    treinosCasa.id = treinosCasa.length + 1
    // setUsers([...users, user])
    const response = await fetch(`${API_ENDPOINT}/treinosCasa/${treinosCasa.id}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosCasa)
    })
    return await response.json();
}