import * as React from 'react';
import {
    ComponentMeta,
    ComponentProps,
    PComponent,
    PropertyTree,
    SizeObject
} from "@inductiveautomation/perspective-client";
import ReactApexChart from 'react-apexcharts';

export const COMPONENT_ID = "timelinechart";

export interface TimelineChartProps {
    series: Array<any>;
    options: any;
}

export function TimelineChart(props: ComponentProps<TimelineChartProps>) {
    const {props: { series, options }} = props;

    return(
        <div>
            <ReactApexChart type="rangeBar" series={series} options={options} height={350} />
        </div>
    );
}

export class TimelineChartMeta implements ComponentMeta {

    getPropsReducer(tree: PropertyTree): TimelineChartProps {
        return {
            series: tree.read('series', []),
            options: tree.read('options', {})
        };
    }

    getComponentType(): string {
        return COMPONENT_ID;
    }

    getDefaultSize(): SizeObject {
        return {
            width: 400,
            height: 400
        };
    }

    getViewComponent(): PComponent {
        return TimelineChart;
    }

}
