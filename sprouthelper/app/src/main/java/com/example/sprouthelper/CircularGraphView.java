package com.example.sprouthelper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public class CircularGraphView extends View {


    private Paint paintArc;
    private Paint paintCircle;
    private Paint paintText;
    private RectF rectF;

    private float circleStrokeWidth = 100;
    private float circleRadius;

    private Typeface customBoldTypeface;

    // Figma 색상 코드
    private final int[] baseColors = {
            Color.parseColor("#F49DAD"),  // 빨강
            Color.parseColor("#95DE5C"), // 초록
            Color.parseColor("#5E87FF"), // 파랑
            Color.parseColor("#B98EFA"), // 보라
            Color.parseColor("#FCC06D") // 노랑
    };

    // 각 구간의 비율 (%)
    private final float[] percentages = {20f, 15f, 30f, 20f, 15f};

    public CircularGraphView(Context context) {
        super(context);
        init();
    }

    public CircularGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        paintArc = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintArc.setStyle(Paint.Style.STROKE);
        paintArc.setStrokeWidth(circleStrokeWidth);
        paintArc.setStrokeCap(Paint.Cap.ROUND);

        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setColor(Color.WHITE);

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(120f);
        paintText.setTextAlign(Paint.Align.CENTER);

        customBoldTypeface = ResourcesCompat.getFont(getContext(), R.font.pretendard_bold);
        if (customBoldTypeface != null) {
            paintText.setTypeface(customBoldTypeface);
        }

        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        circleRadius = Math.min(width, height) / 2 - circleStrokeWidth;
        rectF.set(centerX - circleRadius, centerY - circleRadius,
                centerX + circleRadius, centerY + circleRadius);

        // 퍼센트 합 계산
        float total = 0f;
        for (float p : percentages) {
            total += p;
        }

        if (total == 0f) {
            // ======= 기본 회색 그라데이션 원 =======
            int solidGray = Color.parseColor("#D3D3D3"); // 회색
            int fadeOutGray = Color.argb(0, Color.red(solidGray), Color.green(solidGray), Color.blue(solidGray));

            Shader grayShader = new SweepGradient(centerX, centerY,
                    new int[]{fadeOutGray, solidGray, solidGray, fadeOutGray},
                    new float[]{
                            0f,
                            0.05f,
                            0.95f,
                            1f
                    });

            Matrix grayMatrix = new Matrix();
            grayMatrix.postRotate(-90f, centerX, centerY); // 위쪽부터 시작
            ((SweepGradient) grayShader).setLocalMatrix(grayMatrix);

            paintArc.setShader(grayShader);
            canvas.drawArc(rectF, -90f, 360f, false, paintArc);

            // ======= 끝 점 흰색 원 =======
            float endRadGray = (float) Math.toRadians(-90f + 360f);
            float endXGray = centerX + circleRadius * (float) Math.cos(endRadGray);
            float endYGray = centerY + circleRadius * (float) Math.sin(endRadGray);

            canvas.drawCircle(endXGray, endYGray, circleStrokeWidth / 2.5f, paintCircle);

            // Shader 초기화 (혹시 모를 영향 방지)
            paintArc.setShader(null);

        } else {
            float startAngle = -90f;
            float fadeAngle = 6f;

            for (int i = 0; i < baseColors.length; i++) {
                float sweepAngle = 360f * (percentages[i] / 100f);

                int solid = baseColors[i];
                int fadeOut = Color.argb(0, Color.red(solid), Color.green(solid), Color.blue(solid));

                Shader shader = new SweepGradient(centerX, centerY,
                        new int[]{fadeOut, solid, solid, fadeOut},
                        new float[]{
                                0f,
                                fadeAngle / sweepAngle,
                                (sweepAngle - fadeAngle) / sweepAngle,
                                1f
                        });

                Matrix matrix = new Matrix();
                matrix.postRotate(startAngle, centerX, centerY);
                ((SweepGradient) shader).setLocalMatrix(matrix);

                paintArc.setShader(shader);
                canvas.drawArc(rectF, startAngle, sweepAngle, false, paintArc);

                // 끝 점 흰색 원
                float endRad = (float) Math.toRadians(startAngle + sweepAngle);
                float endX = centerX + circleRadius * (float) Math.cos(endRad);
                float endY = centerY + circleRadius * (float) Math.sin(endRad);
                canvas.drawCircle(endX, endY, circleStrokeWidth / 2.5f, paintCircle);

                startAngle += sweepAngle;
            }
        }
        //중앙 텍스트
        String text = "80%";
        Paint.FontMetrics fm = paintText.getFontMetrics();
        float textOffset = (fm.descent + fm.ascent) / 2;
        canvas.drawText(text, centerX, centerY - textOffset, paintText);
    }
}