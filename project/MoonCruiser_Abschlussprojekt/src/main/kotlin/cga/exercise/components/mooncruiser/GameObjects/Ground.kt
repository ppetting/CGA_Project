package cga.exercise.components.mooncruiser.GameObjects

import cga.exercise.components.camera.TronCamera
import cga.exercise.components.geometry.Material
import cga.exercise.components.geometry.Mesh
import cga.exercise.components.geometry.Renderable
import cga.exercise.components.geometry.VertexAttribute
import cga.exercise.components.texture.Texture2D
import cga.framework.GameWindow
import cga.framework.OBJLoader
import org.joml.Vector2f
import org.joml.Vector3f
import org.lwjgl.opengl.GL11

class Ground : Renderable(){

    var translateVector = Vector3f(5f,5f,5f)

    override fun update(dt: Float, window: GameWindow) {

    }

    override fun init(camera: TronCamera) {
        myCamera = camera

        scaleLocal(translateVector)

        val groundDiff = Texture2D("assets/textures/space.jpeg", true)
        groundDiff.setTexParams(GL11.GL_REPEAT, GL11.GL_REPEAT, GL11.GL_LINEAR_MIPMAP_LINEAR, GL11.GL_LINEAR)
        val groundSpecular = Texture2D("assets/textures/space.jpeg", true)
        groundSpecular.setTexParams(GL11.GL_REPEAT, GL11.GL_REPEAT, GL11.GL_LINEAR_MIPMAP_LINEAR, GL11.GL_LINEAR)
        val groundEmit = Texture2D("assets/textures/moonsurface.jpg", true)
        groundEmit.setTexParams(GL11.GL_REPEAT, GL11.GL_REPEAT, GL11.GL_LINEAR_MIPMAP_LINEAR, GL11.GL_LINEAR)
        var groundMaterial = Material(groundDiff, groundEmit, groundSpecular, 60f, Vector2f(5.0f, 5.0f))

        val gres = OBJLoader.loadOBJ("assets/models/ground.obj")

        val stride = 8 * 4
        val atr1 = VertexAttribute(3, GL11.GL_FLOAT, stride, 0) //position attribute
        val atr2 = VertexAttribute(2, GL11.GL_FLOAT, stride, 3 * 4) //texture coordinate attribut
        val atr3 = VertexAttribute(3, GL11.GL_FLOAT, stride, 5 * 4) //normal attribute

        val vertexAttributes = arrayOf(atr1,atr2,atr3)

       for (m in gres.objects[0].meshes) {
            val mesh = Mesh(m.vertexData, m.indexData, vertexAttributes, groundMaterial)
            this.myMeshes.add(mesh)
        }

    }
}