package ar.adriano.bdasecovid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class Resultado_Testes (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_PACIENTE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $ENFECTADO TEXT NOT NULL, $NAO_ENFECTADO TEXT NOT NULL, M$CONTACTO TEXT NOT NULL, $IDPACIENTE INTEGER NOT NULL,$DATA_NASCIMENTO INTEGER NOT NULL, FOREIGN KEY($IDPACIENTE) REFERENCES ${TabelaCategorias.NOME_TABELA})")
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
        const val NOME_PACIENTE = "NOME"
        const val ENFECTADO = "ENFECTADO"
        const val NAO_ENFECTADO = "NAO_ENFECTADO"
        const val CONTACTO = "CONTACTO"
        const val IDPACIENTE = "ID"
        const val DATA_NASCIMENTO = "DATA_NASCIMENTO"
    }
}
