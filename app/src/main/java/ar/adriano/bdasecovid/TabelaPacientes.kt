package ar.adriano.bdasecovid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaPacientes (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_PACIENTE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $DATA_NASCIMENTO DATE NOT NULL, $CONTACTO TEXT NOT NULL, $DATA_DO_TESTE DATE NOT NULL, FOREIGN KEY($IDPACIENTE) REFERENCES ${Tabela_Enfermeiros.NOME_TABLE})")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaCategorias.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaCategorias.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaCategorias.NOME_TABELA, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(TabelaCategorias.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOME_TABLE = "PACIENTE"
        const val NOME_PACIENTE = "NOME"
        const val SEXO = "SEXO"
        const val DATA_NASCIMENTO = "DATA_NASCIMENTO"
        const val CONTACTO = "CONTACTO"
        const val DATA_DO_TESTE = "DATA_DO_TESTE"
        const val IDPACIENTE = "ID"
    }
}
