/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.client.renderers;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelCrate extends ModelBase {

    // fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;

    public ModelCrate() {
	textureWidth = 128;
	textureHeight = 64;

	Shape1 = new ModelRenderer(this, 0, 34);
	Shape1.addBox(0F, 0F, 0F, 2, 12, 2);
	Shape1.setRotationPoint(6F, 10F, 6F);
	Shape1.setTextureSize(128, 64);
	Shape1.mirror = true;
	setRotation(Shape1, 0F, 0F, 0F);
	Shape2 = new ModelRenderer(this, 0, 0);
	Shape2.addBox(0F, 0F, 0F, 2, 2, 16);
	Shape2.setRotationPoint(-8F, 8F, -8F);
	Shape2.setTextureSize(128, 64);
	Shape2.mirror = true;
	setRotation(Shape2, 0F, 0F, 0F);
	Shape3 = new ModelRenderer(this, 0, 0);
	Shape3.addBox(0F, 0F, 0F, 2, 2, 16);
	Shape3.setRotationPoint(-8F, 22F, -8F);
	Shape3.setTextureSize(128, 64);
	Shape3.mirror = true;
	setRotation(Shape3, 0F, 0F, 0F);
	Shape4 = new ModelRenderer(this, 0, 0);
	Shape4.addBox(0F, 0F, 0F, 2, 2, 16);
	Shape4.setRotationPoint(6F, 22F, -8F);
	Shape4.setTextureSize(128, 64);
	Shape4.mirror = true;
	setRotation(Shape4, 0F, 0F, 0F);
	Shape5 = new ModelRenderer(this, 0, 0);
	Shape5.addBox(0F, 0F, 0F, 2, 2, 16);
	Shape5.setRotationPoint(6F, 8F, -8F);
	Shape5.setTextureSize(128, 64);
	Shape5.mirror = true;
	setRotation(Shape5, 0F, 0F, 0F);
	Shape6 = new ModelRenderer(this, 38, 0);
	Shape6.addBox(0F, 0F, 0F, 12, 2, 2);
	Shape6.setRotationPoint(-6F, 22F, -8F);
	Shape6.setTextureSize(128, 64);
	Shape6.mirror = true;
	setRotation(Shape6, 0F, 0F, 0F);
	Shape7 = new ModelRenderer(this, 38, 0);
	Shape7.addBox(0F, 0F, 0F, 12, 2, 2);
	Shape7.setRotationPoint(-6F, 8F, -8F);
	Shape7.setTextureSize(128, 64);
	Shape7.mirror = true;
	setRotation(Shape7, 0F, 0F, 0F);
	Shape8 = new ModelRenderer(this, 38, 0);
	Shape8.addBox(0F, 0F, 0F, 12, 2, 2);
	Shape8.setRotationPoint(-6F, 22F, 6F);
	Shape8.setTextureSize(128, 64);
	Shape8.mirror = true;
	setRotation(Shape8, 0F, 0F, 0F);
	Shape9 = new ModelRenderer(this, 38, 0);
	Shape9.addBox(0F, 0F, 0F, 12, 2, 2);
	Shape9.setRotationPoint(-6F, 8F, 6F);
	Shape9.setTextureSize(128, 64);
	Shape9.mirror = true;
	setRotation(Shape9, 0F, 0F, 0F);
	Shape10 = new ModelRenderer(this, 72, 36);
	Shape10.addBox(0F, 0F, 0F, 14, 14, 14);
	Shape10.setRotationPoint(-7F, 9F, -7F);
	Shape10.setTextureSize(128, 64);
	Shape10.mirror = true;
	setRotation(Shape10, 0F, 0F, 0F);
	Shape11 = new ModelRenderer(this, 0, 18);
	Shape11.addBox(0F, 0F, 0F, 2, 12, 2);
	Shape11.setRotationPoint(-8F, 10F, 6F);
	Shape11.setTextureSize(128, 64);
	Shape11.mirror = true;
	setRotation(Shape11, 0F, 0F, 0F);
	Shape12 = new ModelRenderer(this, 0, 18);
	Shape12.addBox(0F, 0F, 0F, 2, 12, 2);
	Shape12.setRotationPoint(6F, 10F, -8F);
	Shape12.setTextureSize(128, 64);
	Shape12.mirror = true;
	setRotation(Shape12, 0F, 0F, 0F);
	Shape13 = new ModelRenderer(this, 0, 34);
	Shape13.addBox(0F, 0F, 0F, 2, 12, 2);
	Shape13.setRotationPoint(-8F, 10F, -8F);
	Shape13.setTextureSize(128, 64);
	Shape13.mirror = true;
	setRotation(Shape13, 0F, 0F, 0F);
    }

    public void render(float f5) {
	//setRotationAngles(f, f1, f2, f3, f4, f5);
	Shape1.render(f5);
	Shape2.render(f5);
	Shape3.render(f5);
	Shape4.render(f5);
	Shape5.render(f5);
	Shape6.render(f5);
	Shape7.render(f5);
	Shape8.render(f5);
	Shape9.render(f5);
	Shape10.render(f5);
	Shape11.render(f5);
	Shape12.render(f5);
	Shape13.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
	model.rotateAngleX = x;
	model.rotateAngleY = y;
	model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
	super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }
}
