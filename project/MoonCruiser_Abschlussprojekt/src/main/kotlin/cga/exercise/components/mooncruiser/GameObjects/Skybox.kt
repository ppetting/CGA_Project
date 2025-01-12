package cga.exercise.components.mooncruiser.GameObjects

import cga.exercise.components.camera.TronCamera
import cga.exercise.components.geometry.Material
import cga.exercise.components.geometry.Mesh
import cga.exercise.components.geometry.Renderable
import cga.exercise.components.geometry.VertexAttribute
import cga.exercise.components.light.SpotLight
import cga.exercise.components.texture.Texture2D
import cga.framework.GameWindow
import cga.framework.Vertex
import org.joml.Math
import org.joml.Vector2f
import org.joml.Vector3f
import org.lwjgl.opengl.GL11

class Skybox : Renderable() {

    lateinit var SpotLight : SpotLight

    override fun update(dt: Float, window: GameWindow) {
    }

    override fun init(camera: TronCamera) {
        super.init(camera)
        var vertexArray: MutableList<Vertex> = mutableListOf()

        //front
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(1f,0.5f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(0.75f, 0.5f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(1.0f, 0.75f), Vector3f(0f, 0f, -1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(0.75f, 0.75f), Vector3f(0f, 0f, -1f)))

        //right
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(0.75f, 0.5f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.5f, 0.5f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(0.75f, 0.75f), Vector3f(1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(0.5f, 0.75f), Vector3f(1f, 0f, 0f)))

        //back = behind
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.5f, 0.5f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0.25f, 0.5f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(0.5f, 0.75f), Vector3f(0f, 0f, 1f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(0.25f, 0.75f), Vector3f(0f, 0f, 1f)))

       //left
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0.25f, 0.5f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(0.0f, 0.5f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(0.25f, 0.75f), Vector3f(-1f, 0f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(0.0f, 0.75f), Vector3f(-1f, 0f, 0f)))

        //up
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, 0.5f), Vector2f(1f, 0.75f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, 0.5f, -0.5f), Vector2f(0.75f, 0.75f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, 0.5f), Vector2f(1f, 1.0f), Vector3f(0f, 1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, 0.5f, -0.5f), Vector2f(0.75f, 1.0f), Vector3f(0f, 1f, 0f)))

        //down
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, -0.5f), Vector2f(1.0f, 0.25f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(-0.5f, -0.5f, 0.5f), Vector2f(0.75f, 0.25f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, -0.5f), Vector2f(1.0f, 0.5f), Vector3f(0f, -1f, 0f)))
        vertexArray.add(Vertex(Vector3f(0.5f, -0.5f, 0.5f), Vector2f(0.75f, 0.5f), Vector3f(0f, -1f, 0f)))

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

        val skybox = Texture2D("assets/textures/Skybox.png", true)
        skybox.setTexParams(GL11.GL_REPEAT, GL11.GL_REPEAT, GL11.GL_LINEAR_MIPMAP_LINEAR, GL11.GL_LINEAR)
        var skyboxMaterial = Material(skybox, skybox, skybox, 60f, Vector2f(1.0f, 1.0f))

            val mesh = Mesh(vertexdata, indexdata, vertexAttributes, skyboxMaterial)
            this.myMeshes.add(mesh)

        scaleLocal(Vector3f(220f,220f,220f))

        SpotLight = SpotLight(Vector3f(50.0f, 50.0f, 50.0f), Vector3f(-0.5f, 0.25f, -1.75f), Math.toRadians(10.0f), Math.toRadians(30.0f))
    }

    override fun render(dt: Float, t: Float) {
        super.render(dt, t)
        SpotLight.bind(myShader, "bikeSpotLight", myCamera.calculateViewMatrix())

    }
}





