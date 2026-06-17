package org.jupnp.support.renderingcontrol;

import org.jupnp.binding.annotations.UpnpAction;
import org.jupnp.binding.annotations.UpnpInputArgument;
import org.jupnp.binding.annotations.UpnpOutputArgument;
import org.jupnp.binding.annotations.UpnpService;
import org.jupnp.binding.annotations.UpnpServiceId;
import org.jupnp.binding.annotations.UpnpServiceType;
import org.jupnp.binding.annotations.UpnpStateVariable;
import org.jupnp.binding.annotations.UpnpStateVariables;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;
import org.jupnp.support.lastchange.LastChange;
import org.jupnp.support.lastchange.LastChangeDelegator;
import org.jupnp.support.model.Channel;
import org.jupnp.support.model.PresetName;
import org.jupnp.support.model.VolumeDBRange;
import org.jupnp.support.renderingcontrol.lastchange.ChannelLoudness;
import org.jupnp.support.renderingcontrol.lastchange.ChannelMute;
import org.jupnp.support.renderingcontrol.lastchange.ChannelVolume;
import org.jupnp.support.renderingcontrol.lastchange.ChannelVolumeDB;
import org.jupnp.support.renderingcontrol.lastchange.RenderingControlLastChangeParser;
import org.jupnp.support.renderingcontrol.lastchange.RenderingControlVariable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@UpnpService(serviceId = @UpnpServiceId("RenderingControl"), serviceType = @UpnpServiceType(value = "RenderingControl", version = 1), stringConvertibleTypes = {LastChange.class})
@UpnpStateVariables({@UpnpStateVariable(datatype = "string", name = "PresetNameList", sendEvents = false), @UpnpStateVariable(datatype = "boolean", name = "Mute", sendEvents = false), @UpnpStateVariable(allowedValueMaximum = 100, allowedValueMinimum = 0, datatype = "ui2", name = "Volume", sendEvents = false), @UpnpStateVariable(allowedValueMaximum = 32767, allowedValueMinimum = -36864, datatype = "i2", name = "VolumeDB", sendEvents = false), @UpnpStateVariable(datatype = "boolean", name = "Loudness", sendEvents = false), @UpnpStateVariable(allowedValuesEnum = Channel.class, name = "A_ARG_TYPE_Channel", sendEvents = false), @UpnpStateVariable(allowedValuesEnum = PresetName.class, name = "A_ARG_TYPE_PresetName", sendEvents = false), @UpnpStateVariable(datatype = "ui4", name = "A_ARG_TYPE_InstanceID", sendEvents = false)})
public abstract class AbstractAudioRenderingControl implements LastChangeDelegator {

    @UpnpStateVariable(eventMaximumRateMilliseconds = 200)
    private final LastChange lastChange;
    protected final PropertyChangeSupport propertyChangeSupport;

    public AbstractAudioRenderingControl() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.lastChange = new LastChange(new RenderingControlLastChangeParser());
    }

    public static UnsignedIntegerFourBytes getDefaultInstanceID() {
        return new UnsignedIntegerFourBytes(0L);
    }

    @Override // org.jupnp.support.lastchange.LastChangeDelegator
    public void appendCurrentState(LastChange lastChange, UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        for (Channel channel : getCurrentChannels()) {
            String strName = channel.name();
            lastChange.setEventedValue(unsignedIntegerFourBytes, new RenderingControlVariable.Mute(new ChannelMute(channel, Boolean.valueOf(getMute(unsignedIntegerFourBytes, strName)))), new RenderingControlVariable.Loudness(new ChannelLoudness(channel, Boolean.valueOf(getLoudness(unsignedIntegerFourBytes, strName)))), new RenderingControlVariable.Volume(new ChannelVolume(channel, Integer.valueOf(getVolume(unsignedIntegerFourBytes, strName).getValue().intValue()))), new RenderingControlVariable.VolumeDB(new ChannelVolumeDB(channel, getVolumeDB(unsignedIntegerFourBytes, strName))), new RenderingControlVariable.PresetNameList(PresetName.FactoryDefaults.name()));
        }
    }

    public Channel getChannel(String str) throws RenderingControlException {
        try {
            return Channel.valueOf(str);
        } catch (IllegalArgumentException unused) {
            throw new RenderingControlException(ErrorCode.ARGUMENT_VALUE_INVALID, "Unsupported audio channel: " + str);
        }
    }

    public abstract Channel[] getCurrentChannels();

    @Override // org.jupnp.support.lastchange.LastChangeDelegator
    public LastChange getLastChange() {
        return this.lastChange;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentLoudness", stateVariable = "Loudness")})
    public boolean getLoudness(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) {
        return false;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentMute", stateVariable = "Mute")})
    public abstract boolean getMute(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str);

    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentVolume", stateVariable = "Volume")})
    public abstract UnsignedIntegerTwoBytes getVolume(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str);

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentVolume", stateVariable = "VolumeDB")})
    public Integer getVolumeDB(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) {
        return 0;
    }

    @UpnpAction(out = {@UpnpOutputArgument(getterName = "getMinValue", name = "MinValue", stateVariable = "VolumeDB"), @UpnpOutputArgument(getterName = "getMaxValue", name = "MaxValue", stateVariable = "VolumeDB")})
    public VolumeDBRange getVolumeDBRange(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) {
        return new VolumeDBRange(0, 0);
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentPresetNameList", stateVariable = "PresetNameList")})
    public String listPresets(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        return PresetName.FactoryDefaults.toString();
    }

    @UpnpAction
    public void selectPreset(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "PresetName") String str) {
    }

    @UpnpAction
    public void setLoudness(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredLoudness", stateVariable = "Loudness") boolean z) {
    }

    @UpnpAction
    public abstract void setMute(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredMute", stateVariable = "Mute") boolean z);

    @UpnpAction
    public abstract void setVolume(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredVolume", stateVariable = "Volume") UnsignedIntegerTwoBytes unsignedIntegerTwoBytes);

    @UpnpAction
    public void setVolumeDB(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredVolume", stateVariable = "VolumeDB") Integer num) {
    }

    public AbstractAudioRenderingControl(LastChange lastChange) {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.lastChange = lastChange;
    }

    public AbstractAudioRenderingControl(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
        this.lastChange = new LastChange(new RenderingControlLastChangeParser());
    }

    public AbstractAudioRenderingControl(PropertyChangeSupport propertyChangeSupport, LastChange lastChange) {
        this.propertyChangeSupport = propertyChangeSupport;
        this.lastChange = lastChange;
    }
}
