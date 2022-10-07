标签定义及使用说明
grid 是一个 CSS 所有网格容器的简写属性，可以用来设置以下属性：

显式网格属性： grid-template-rows、grid-template-columns 和 grid-template-areas。
隐式网格属性： grid-auto-rows、grid-auto-columns 和 grid-auto-flow。
间距属性： grid-column-gap 和 grid-row-gap。

默认值:	none none none auto auto row
继承:	no

值	描述
none	                                                  默认值。不定义行或列的尺寸。
grid-template-rows / grid-template-columns	            设置列和行的尺寸。
grid-template-areas	                                    指定网格布局使用的网格项名称
grid-template-rows / grid-auto-columns	                指定行的尺寸（高度），以及列的自动尺寸。
grid-auto-rows / grid-template-columns	                指定行的自动尺寸，并设置 grid-template-columns 属性。
grid-template-rows / grid-auto-flow grid-auto-columns	  指定行的尺寸（高度），以及自动布局算法怎样运作，和列的自动尺寸。
grid-auto-flow grid-auto-rows / grid-template-columns	  指定自动布局算法怎样运作，和行的自动尺寸，以及设置 grid-template-columns 属性。
initial	                                                属性设置为默认值 阅读 initial
inherit	                                                从父原生继承该属性， 阅读 inherit

















