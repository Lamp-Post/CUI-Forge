package cui.mods.modloader;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class WireEntity extends Entity
{
  public WireEntity(World world)
  {
    super(world);
    this.ignoreFrustumCheck = true;
    this.noClip = true;
    setSize(0, 0);
  }

@Override
protected void entityInit() {
	
}

@Override
protected void readEntityFromNBT(NBTTagCompound arg0) {
}

@Override
protected void writeEntityToNBT(NBTTagCompound arg0) {
}

  public void onUpdate()
  {
  }

  public void setDead()
  {
  }

  public String getEntityName()
  {
    return "CUI";
  }

  public boolean isInRangeToRenderVec3D(Vec3 vector)
  {
    return true;
  }

  public int getBrightnessForRender(float f)
  {
    return 15728880;
  }

  public float getBrightness(float f)
  {
    return 1.0F;
  }
}