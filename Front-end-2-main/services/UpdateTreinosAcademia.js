const updateTreinosAcademia = treinosAcademia => {
    treinosAcademia.id = treinosAcademia.length + 1
    // setUsers([...users, user])
    const response = await fetch(`${API_ENDPOINT}/treinosAcademia/${Academia.id}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosAcademia)
    })
    return await response.json();
}