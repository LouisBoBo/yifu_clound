/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xui.widget.imageview.preview;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.xuexiang.xui.widget.imageview.preview.enitity.IPreviewInfo;
import com.xuexiang.xui.widget.imageview.preview.loader.OnVideoClickListener;
import com.xuexiang.xui.widget.imageview.preview.ui.BasePhotoFragment;
import com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity;

import java.util.ArrayList;
import java.util.List;

import static com.xuexiang.xui.widget.imageview.preview.ui.BasePhotoFragment.KEY_DRAG;
import static com.xuexiang.xui.widget.imageview.preview.ui.BasePhotoFragment.KEY_PROGRESS_COLOR;
import static com.xuexiang.xui.widget.imageview.preview.ui.BasePhotoFragment.KEY_SENSITIVITY;
import static com.xuexiang.xui.widget.imageview.preview.ui.BasePhotoFragment.KEY_SING_FILING;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_CLASSNAME;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_DURATION;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_IMAGE_PATHS;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_IS_FULLSCREEN;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_IS_SHOW;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_POSITION;
import static com.xuexiang.xui.widget.imageview.preview.ui.PreviewActivity.KEY_TYPE;

/**
 * ?????????
 *
 * @author xuexiang
 * @since 2018/12/5 ??????11:46
 */
public final class PreviewBuilder {
    private Activity mContext;
    private Intent intent;
    private Class className;
    private OnVideoClickListener videoClickListener;

    private PreviewBuilder(@NonNull Activity activity) {
        mContext = activity;
        intent = new Intent();
    }

    /**
     * ????????????????????????
     *
     * @param activity ????????????
     * @return
     */
    public static PreviewBuilder from(@NonNull Activity activity) {
        return new PreviewBuilder(activity);
    }

    /**
     * ????????????????????????
     *
     * @param fragment ????????????
     * @return
     */
    public static PreviewBuilder from(@NonNull Fragment fragment) {
        return new PreviewBuilder(fragment.getActivity());
    }

    /****
     * ???????????????activity ??????
     * @param className   ??????GPreviewActivity
     * @return PreviewBuilder
     */
    public PreviewBuilder to(@NonNull Class className) {
        this.className = className;
        intent.setClass(mContext, className);
        return this;
    }

    /**
     * ?????????????????????
     *
     * @param imgUrls ??????
     * @param <T>
     * @return
     */
    public <T extends IPreviewInfo> PreviewBuilder setImgs(@NonNull List<T> imgUrls) {
        intent.putParcelableArrayListExtra(KEY_IMAGE_PATHS, new ArrayList<Parcelable>(imgUrls));
        return this;
    }

    /***
     * ???????????????????????????
     * @param imgUrl ??????
     * @param <E> ?????????????????????
     * @return PreviewBuilder
     */
    public <E extends IPreviewInfo> PreviewBuilder setImg(@NonNull E imgUrl) {
        ArrayList arrayList = new ArrayList<Parcelable>();
        arrayList.add(imgUrl);
        intent.putParcelableArrayListExtra(KEY_IMAGE_PATHS, arrayList);
        return this;
    }

    /***
     * ??????????????????fragment
     * @param className ??????Fragment???
     * @return PreviewBuilder
     * **/
    public PreviewBuilder setPhotoFragment(@NonNull Class<? extends BasePhotoFragment> className) {
        intent.putExtra(KEY_CLASSNAME, className);
        return this;
    }

    /***
     * ??????????????????
     * @param currentIndex ??????
     * @return PreviewBuilder
     */
    public PreviewBuilder setCurrentIndex(int currentIndex) {
        intent.putExtra(KEY_POSITION, currentIndex);
        return this;
    }

    /***
     * ?????????????????????
     * @param indicatorType ??????
     * @return PreviewBuilder
     */
    public PreviewBuilder setType(@NonNull IndicatorType indicatorType) {
        intent.putExtra(KEY_TYPE, indicatorType);
        return this;
    }

    /***
     * ???????????????????????????????????????
     * @param progressColorId   ????????????????????????ID
     * @return PreviewBuilder
     */
    public PreviewBuilder setProgressColor(@ColorRes int progressColorId) {
        intent.putExtra(KEY_PROGRESS_COLOR, progressColorId);
        return this;
    }

    /***
     * ??????????????????????????????
     * @param isDrag  true  ?????? false ?????? true
     * @return PreviewBuilder
     */
    public PreviewBuilder setDrag(boolean isDrag) {
        intent.putExtra(KEY_DRAG, isDrag);
        return this;
    }

    /***
     * ??????????????????????????????
     * @param isDrag  true  ?????? false ?????? true
     * @param sensitivity   sensitivity mMaxTransScale ???????????????????????????
     * @return PreviewBuilder
     */
    public PreviewBuilder setDrag(boolean isDrag, float sensitivity) {
        intent.putExtra(KEY_DRAG, isDrag);
        intent.putExtra(KEY_SENSITIVITY, sensitivity);
        return this;
    }

    /***
     * ?????????????????????????????? ???????????????  ????????????
     * @param isShow   true  ?????? false ?????????
     * @return PreviewBuilder
     */
    public PreviewBuilder setSingleShowType(boolean isShow) {
        intent.putExtra(KEY_IS_SHOW, isShow);
        return this;
    }

    /***
     * ????????????????????????????????????????????????
     * @param isSingleFling  true  ?????? false
     * @return PreviewBuilder
     */
    public PreviewBuilder setSingleFling(boolean isSingleFling) {
        intent.putExtra(KEY_SING_FILING, isSingleFling);
        return this;
    }

    /***
     * ?????????????????????
     * @param setDuration  ????????????
     * @return PreviewBuilder
     */
    public PreviewBuilder setDuration(int setDuration) {
        intent.putExtra(KEY_DURATION, setDuration);
        return this;
    }

    /***
     *  ??????????????????
     * @param isFullscreen  ????????????
     * @return PreviewBuilder
     */
    public PreviewBuilder setFullscreen(boolean isFullscreen) {
        intent.putExtra(KEY_IS_FULLSCREEN, isFullscreen);
        return this;
    }

    /***
     *  ?????????????????????????????????
     * @return PreviewBuilder
     */
    public PreviewBuilder setOnVideoPlayerListener(OnVideoClickListener listener) {
        this.videoClickListener = listener;
        return this;
    }

    /***
     * ??????
     */
    public void start() {
        if (className == null) {
            intent.setClass(mContext, PreviewActivity.class);
        } else {
            intent.setClass(mContext, className);
        }
        BasePhotoFragment.listener = videoClickListener;
        mContext.startActivity(intent);
        mContext.overridePendingTransition(0, 0);
        intent = null;
        mContext = null;
    }

    /**
     * ???????????????
     */
    public enum IndicatorType {
        /**
         * ???
         */
        Dot,
        /**
         * ??????
         */
        Number
    }
}
