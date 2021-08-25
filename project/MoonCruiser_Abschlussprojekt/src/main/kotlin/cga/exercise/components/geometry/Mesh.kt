package cga.exercise.components.geometry

import cga.exercise.components.shader.ShaderProgram
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.GL15
import org.lwjgl.opengl.GL20
import org.lwjgl.opengl.GL30


class Mesh(vertexdata: FloatArray, indexdata: IntArray, attributes: Array<VertexAttribute>, private val material: Material) {

    private var vao = 0
    private var vbo = 0
    private var ibo = 0
    private var indexcount = 0

    init {
        vao = GL30.glGenVertexArrays()
        if (vao == 0) {
            throw Exception("Vertex array object creation failed.")
        }
        vbo = GL15.glGenBuffers()
        if (vbo == 0) {
            GL30.glDeleteVertexArrays(vao)
            throw Exception("Vertex buffer creation failed.")
        }
        ibo = GL15.glGenBuffers()
        if (ibo == 0) {
            GL30.glDeleteVertexArrays(vao)
            GL15.glDeleteBuffers(vbo)
            throw Exception("Index buffer creation failed.")
        }
        GL30.glBindVertexArray(vao)
        //---------------------- VAO state setup start ----------------------
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo)
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo)

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexdata, GL15.GL_STATIC_DRAW)
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indexdata, GL15.GL_STATIC_DRAW)

        for (i in attributes.indices) {
            GL20.glEnableVertexAttribArray(i)
            GL20.glVertexAttribPointer(
                    i,
                    attributes[i].n,
                    attributes[i].type,
                    false,
                    attributes[i].stride,
                    attributes[i].offset
                            .toLong())
        }
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0)

        GL30.glBindVertexArray(0)
        indexcount = indexdata.size
    }

    private fun render() {
        GL30.glBindVertexArray(vao)
        GL11.glDrawElements(GL11.GL_TRIANGLES, indexcount, GL11.GL_UNSIGNED_INT, 0)
        GL30.glBindVertexArray(0)
    }

    fun render(shaderProgram: ShaderProgram) {
        shaderProgram.saveTU()
        material.bind(shaderProgram)
        render()
        shaderProgram.resetTU()
    }

    fun cleanup() {
        if (ibo != 0) GL15.glDeleteBuffers(ibo)
        if (vbo != 0) GL15.glDeleteBuffers(vbo)
        if (vao != 0) GL30.glDeleteVertexArrays(vao)
    }
}