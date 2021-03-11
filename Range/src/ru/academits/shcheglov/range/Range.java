package ru.academits.shcheglov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getRangesIntersection(Range range) {
        if (this.from >= range.to || this.to <= range.from) {
            return null;
        }

        if (this.from >= range.from && this.to <= range.to) {
            return new Range(this.from, this.to);
        }

        if (this.from >= range.from && this.to > range.to) {
            return new Range(this.from, range.to);
        }

        if (this.from < range.from && this.to <= range.to) {
            return new Range(range.from, this.to);
        }

        return new Range(range.from, range.to);
    }

    public Range[] getRangesUnion(Range range) {
        if (this.from > range.to || this.to < range.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }

        if (this.from <= range.from && this.to >= range.to) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if ((this.from <= range.from && this.to < range.to) || this.to == range.from) {
            return new Range[]{new Range(this.from, range.to)};
        }

        if ((this.from > range.from && this.to >= range.to) || this.from == range.to) {
            return new Range[]{new Range(range.from, this.to)};
        }

        return new Range[]{new Range(range.from, range.to)};
    }

    public Range[] getRangesDifference(Range range) {
        if (this.from < range.from && this.to > range.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        if (this.from >= range.from && this.to > range.to) {
            return new Range[]{new Range(range.to, this.to)};
        }

        if (this.from < range.from && this.to <= range.to) {
            return new Range[]{new Range(this.from, range.from)};
        }

        return new Range[]{null};
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }
}