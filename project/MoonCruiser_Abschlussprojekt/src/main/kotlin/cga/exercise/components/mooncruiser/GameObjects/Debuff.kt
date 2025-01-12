package cga.exercise.components.mooncruiser.GameObjects

import cga.exercise.components.camera.TronCamera
import cga.exercise.components.geometry.*
import cga.exercise.components.texture.Texture2D
import cga.framework.GameWindow
import cga.framework.Vertex
import org.joml.Vector2f
import org.joml.Vector3f
import org.lwjgl.opengl.GL11

class Debuff(koordinatenVector : Vector3f, rotationsVector : Vector3f) : Renderable() {

    var translateVector = Vector3f(koordinatenVector)
    var rotateVector = Vector3f(rotationsVector)

    override fun update(dt: Float, window: GameWindow) {
        rotateLocal(dt, dt, dt)
        rotateAroundPoint(0f, dt*0.75f, 0f, rotateVector)
    }

    override fun init(camera: TronCamera) {

        translateLocal(translateVector)
        scaleLocal(Vector3f(1f,1f,1f))

        super.init(camera)
        var vertexArray: MutableList<Vertex> = mutableListOf()

        //front
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(0.25f,0.66f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(0.25f, 0.33f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(0.5f, 0.66f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(0.5f, 0.33f), Vector3f(0f, 0f, -1f)))

        //right
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(0.8f, 1f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.8f, 0.66f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(1f, 1f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(1f, 0.66f), Vector3f(1f, 0f, 0f)))

        //back
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.75f, 0.66f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0.75f, 0.33f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(1f, 0.66f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(1f, 0.33f), Vector3f(0f, 0f, 1f)))

        //left
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0.8f, 0.33f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(0.8f, 0.0f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(1f, 0.33f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(1f, 0.0f), Vector3f(-1f, 0f, 0f)))

        //up
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(0.5f, 0.66f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(0.5f, 0.33f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(0.75f, 0.66f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(0.75f, 0.33f), Vector3f(0f, 1f, 0f)))

        //down
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(0f, 0.66f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0f, 0.33f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(0.25f, 0.66f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.25f, 0.33f), Vector3f(0f, -1f, 0f)))

        val vertexdata = FloatArray(8 * vertexArray.size)
        var vertexdi = 0
        for (v in vertexArray) {
            vertexdata[vertexdi++] = v.position.x
            vertexdata[vertexdi++] = v.position.y
            vertexdata[vertexdi++] = v.position.z
            vertexdata[vertexdi++] = v.texCoord.x
            vertexdata[vertexdi++] = v.texCoord.y
            vertexdata[vertexdi++] = v.normal.x
            vertexdata[vertexdi++] = v.normal.y
            vertexdata[vertexdi++] = v.normal.z
        }

        var indexList : MutableList<Int> = mutableListOf()
        var i = 0

        for (y in 5 downTo 0 step 1) {
            indexList.add( 3 + i * 4)
            indexList.add( 2 + i * 4)
            indexList.add( 0 + i * 4)


            indexList.add( 0 + i * 4)
            indexList.add( 1 + i * 4)
            indexList.add( 3 + i * 4)

            i++
        }

        val indexdata = IntArray(indexList.size)
        var indexdi = 0
        for (i in indexList) {
            indexdata[indexdi++] = i
        }

        val stride = 8 * 4
        val atr1 = VertexAttribute(3, GL11.GL_FLOAT, stride, 0) //position attribute
        val atr2 = VertexAttribute(2, GL11.GL_FLOAT, stride, 3 * 4) //texture coordinate attribut
        val atr3 = VertexAttribute(3, GL11.GL_FLOAT, stride, 5 * 4) //normal attribute
        val vertexAttributes = arrayOf(atr1, atr2, atr3)

        val debuff = Texture2D("assets/textures/debuff_texture.jpg", true)
        debuff.setTexParams(GL11.GL_REPEAT, GL11.GL_REPEAT, GL11.GL_LINEAR_MIPMAP_LINEAR, GL11.GL_LINEAR)
        var debuffMaterial = Material(debuff, debuff, debuff, 60f, Vector2f(1.0f, 1.0f))

        val mesh = Mesh(vertexdata, indexdata, vertexAttributes, debuffMaterial)
        this.myMeshes.add(mesh)


}
}