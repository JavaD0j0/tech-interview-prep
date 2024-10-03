# Pattern: Merge Intervals

The merge intervals pattern deals with problems involving overlapping intervals. Each interval is represented by a start and an end time. For example, an interval of [10,20] seconds means that the interval starts at 10 seconds and ends at 20 seconds. This pattern involves tasks such as merging intersecting intervals, inserting new intervals into existing sets, or determining the minimum number of intervals needed to cover a given range. The most common problems solved using this pattern are event scheduling, resource allocation, and time slot consolidation.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Array of intervals`: The input data is an array of intervals.
- `Overlapping intervals`: The problem requires dealing with overlapping intervals, either to find their union, their intersection, or the gaps between them.

## Examples

Problems that can be solved with this approach:

1. `Merge intervals`: Given a sorted list of intervals, merge all overlapping intervals.
2. `Meeting rooms`: Given an array of meeting time intervals consisting of start and end times, determine if a person could attend all meetings.
