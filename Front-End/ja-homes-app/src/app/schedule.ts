export interface Schedule {
    schedule_id?: number;
    doctor_id: number;
    schedule_startTime: string;
    schedule_endTime: string;
    isAvailable: boolean;
}
