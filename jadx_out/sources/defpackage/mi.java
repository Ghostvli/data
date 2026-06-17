package defpackage;

import defpackage.no4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mi implements hd3 {
    public final no4.d a = new no4.d();

    @Override // defpackage.hd3
    public final void addMediaItem(int i, fg2 fg2Var) {
        addMediaItems(i, xi1.w(fg2Var));
    }

    @Override // defpackage.hd3
    public final void addMediaItems(List list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    public final int b() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void c(int i) {
        e(-1, -9223372036854775807L, i, false);
    }

    @Override // defpackage.hd3
    public final boolean canAdvertiseSession() {
        return true;
    }

    @Override // defpackage.hd3
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public final void d(int i) {
        e(getCurrentMediaItemIndex(), -9223372036854775807L, i, true);
    }

    public abstract void e(int i, long j, int i2, boolean z);

    public final void f(long j, int i) {
        e(getCurrentMediaItemIndex(), j, i, false);
    }

    public final void g(int i, int i2) {
        e(i, -9223372036854775807L, i2, false);
    }

    @Override // defpackage.hd3
    public final int getBufferedPercentage() {
        if (!isCommandAvailable(16)) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return fy4.s(fy4.n1(bufferedPosition, duration), 0, 100);
    }

    @Override // defpackage.hd3
    public final long getContentDuration() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return -9223372036854775807L;
        }
        return currentTimeline.t(getCurrentMediaItemIndex(), this.a).e();
    }

    @Override // defpackage.hd3
    public final long getCurrentLiveOffset() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w() || currentTimeline.t(getCurrentMediaItemIndex(), this.a).f == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (this.a.b() - this.a.f) - getContentPosition();
    }

    @Override // defpackage.hd3
    public final Object getCurrentManifest() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return null;
        }
        return currentTimeline.t(getCurrentMediaItemIndex(), this.a).d;
    }

    @Override // defpackage.hd3
    public final fg2 getCurrentMediaItem() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return null;
        }
        return currentTimeline.t(getCurrentMediaItemIndex(), this.a).c;
    }

    @Override // defpackage.hd3
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // defpackage.hd3
    public final fg2 getMediaItemAt(int i) {
        return getCurrentTimeline().t(i, this.a).c;
    }

    @Override // defpackage.hd3
    public final int getMediaItemCount() {
        return getCurrentTimeline().v();
    }

    @Override // defpackage.hd3
    public final int getNextMediaItemIndex() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return -1;
        }
        return currentTimeline.k(getCurrentMediaItemIndex(), b(), getShuffleModeEnabled());
    }

    @Override // defpackage.hd3
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // defpackage.hd3
    public final int getPreviousMediaItemIndex() {
        no4 currentTimeline = getCurrentTimeline();
        if (currentTimeline.w()) {
            return -1;
        }
        return currentTimeline.r(getCurrentMediaItemIndex(), b(), getShuffleModeEnabled());
    }

    @Override // defpackage.hd3
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    public final void h(int i) {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex == -1) {
            c(i);
        } else if (nextMediaItemIndex == getCurrentMediaItemIndex()) {
            d(i);
        } else {
            g(nextMediaItemIndex, i);
        }
    }

    @Override // defpackage.hd3
    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Override // defpackage.hd3
    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    public final void i(long j, int i) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        f(Math.max(currentPosition, 0L), i);
    }

    @Override // defpackage.hd3
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().c(i);
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemDynamic() {
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).i;
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemLive() {
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).g();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentMediaItemSeekable() {
        no4 currentTimeline = getCurrentTimeline();
        return !currentTimeline.w() && currentTimeline.t(getCurrentMediaItemIndex(), this.a).h;
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // defpackage.hd3
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // defpackage.hd3
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void j(int i) {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex == -1) {
            c(i);
        } else if (previousMediaItemIndex == getCurrentMediaItemIndex()) {
            d(i);
        } else {
            g(previousMediaItemIndex, i);
        }
    }

    public final void k(List list) {
        setMediaItems(list, true);
    }

    @Override // defpackage.hd3
    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // defpackage.hd3
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // defpackage.hd3
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // defpackage.hd3
    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // defpackage.hd3
    public final void replaceMediaItem(int i, fg2 fg2Var) {
        replaceMediaItems(i, i + 1, xi1.w(fg2Var));
    }

    @Override // defpackage.hd3
    public final void seekBack() {
        i(-getSeekBackIncrement(), 11);
    }

    @Override // defpackage.hd3
    public final void seekForward() {
        i(getSeekForwardIncrement(), 12);
    }

    @Override // defpackage.hd3
    public final void seekTo(int i, long j) {
        e(i, j, 10, false);
    }

    @Override // defpackage.hd3
    public final void seekToDefaultPosition() {
        g(getCurrentMediaItemIndex(), 4);
    }

    @Override // defpackage.hd3
    public final void seekToNext() {
        if (getCurrentTimeline().w() || isPlayingAd()) {
            c(9);
            return;
        }
        if (hasNextMediaItem()) {
            h(9);
        } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
            g(getCurrentMediaItemIndex(), 9);
        } else {
            c(9);
        }
    }

    @Override // defpackage.hd3
    public final void seekToNextMediaItem() {
        h(8);
    }

    @Override // defpackage.hd3
    public final void seekToPrevious() {
        if (getCurrentTimeline().w() || isPlayingAd()) {
            c(7);
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                j(7);
                return;
            } else {
                c(7);
                return;
            }
        }
        if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
            f(0L, 7);
        } else {
            j(7);
        }
    }

    @Override // defpackage.hd3
    public final void seekToPreviousMediaItem() {
        j(6);
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var, long j) {
        setMediaItems(xi1.w(fg2Var), 0, j);
    }

    @Override // defpackage.hd3
    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(getPlaybackParameters().d(f));
    }

    @Override // defpackage.hd3
    public final void addMediaItem(fg2 fg2Var) {
        addMediaItems(xi1.w(fg2Var));
    }

    @Override // defpackage.hd3
    public final void seekToDefaultPosition(int i) {
        g(i, 10);
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var) {
        k(xi1.w(fg2Var));
    }

    @Override // defpackage.hd3
    public final void seekTo(long j) {
        f(j, 5);
    }

    @Override // defpackage.hd3
    public final void setMediaItem(fg2 fg2Var, boolean z) {
        setMediaItems(xi1.w(fg2Var), z);
    }
}
