import React from 'react'
import Link from 'next/link'
import AddTreinoCasaForms from '../../components/Forms/AddTreinoCasaForms'
import AddTreinosAcademiaForm from '../../components/Forms/AddTreinosAcademia'
import TreinosCasaTable from '../../components/Tables/TreinosCasaTables'
import TreinosAcademiaTable from '../../components/Tables/TreinosAcademiaTables'

export default function Personal() {
  const treinos = [{
    id: 'aaaa',
    personal: 'aaa',
    cliente: 'cliente',
    data: 'data',
    endereco: 'endereco',
    tipo: 'tipo',
    academia: 'academia'
  }]
  return (
    <div>
      <AddTreinoCasaForms />
      <TreinosCasaTable treinosCasas={treinos} />
      {/* TROCAR treinos pelo data do banco backend */}
      <AddTreinosAcademiaForm />
      <TreinosAcademiaTable treinosAcademias={treinos} />
      <Link href='/'>
        <button>Voltar</button>
      </Link>
    </div>

  )
}
